package com.salmon.board.controller;
import com.salmon.board.domain.Board;
import com.salmon.board.domain.User;
import com.salmon.board.domain.dto.BoardListResponseDto;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.domain.dto.MsgResponseDto;
import com.salmon.board.security.UserDetailsImpl;
import com.salmon.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Api(tags={"게시판 관련 APi"})
public class BoardController {
    private final BoardService boardService;

    //Test
    @GetMapping("/hello")
    public String hello(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<BoardListResponseDto> findBoardList = boardService.findAll();

        model.addAttribute("cnt", findBoardList);
        model.addAttribute("test", 2);

        return "hello";
    }

    @GetMapping("/")
    public String home(Model model){
        return "redirect:/board/List";
    }

    //Create Page Rendering
    @GetMapping("/board/save")
    public String saveBoardRendering(){
        return "addForm";
    }

    //Create Post
    @PostMapping("/board/save")
    public MsgResponseDto saveBoard(@RequestBody @ModelAttribute BoardRequestDto boardRequestDto,
                                    @AuthenticationPrincipal UserDetailsImpl userDetails){

        User user = userDetails.getUser();
        Board save = boardService.save(boardRequestDto, user);

        MsgResponseDto msgResponseDto = new MsgResponseDto("게시글 저장에 성공하였습니다.");


        return msgResponseDto;
    }

    //Read One Rendering
    @GetMapping("/board")
    public String readBoard(@RequestParam(value = "id", defaultValue = "0", required = true) Long id,
                            Model model,
                            @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        BoardResponseDto findBoard = boardService.findById(id);

        if(userDetails == null) {
            model.addAttribute("userBackendId", 0);
        }
        else{
            model.addAttribute("userBackendId", userDetails.getUser().getId());
        }


        model.addAttribute("board", findBoard);

        return "board";
    }

    //Read List Rendering
    @GetMapping("/board/List")
    public String readBoardList(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<BoardListResponseDto> findBoardList = boardService.findAll();

        if(userDetails == null) {
            model.addAttribute("userBackendId", 0);
        }
        else{
            model.addAttribute("userBackendId", userDetails.getUser().getId());
        }

        model.addAttribute("boardList", findBoardList);

        return "boardList";
    }

    //Update Page Rendering
    @GetMapping("/board/update")
    public String updateBoardRendering(@RequestParam(value = "id", required = true) Long id, Model  model){
        BoardResponseDto findBoard = boardService.findById(id);

        model.addAttribute("board", findBoard);

        return "editForm";
    }

    //Update
    @PutMapping("/board/update")
    public String updateBoard(@RequestParam(value = "id", required = true)Long id, @RequestBody @ModelAttribute BoardRequestDto boardRequestDto){
        Board updateBoard = boardService.update(id, boardRequestDto);
        return "boardList";
    }

    //Delete
    @GetMapping("/board/delete")
    public String deleteBoard(@RequestParam(value = "id", required = true)Long id){
        boardService.delete(id);
        return "redirect:/board/List";
    }
}
