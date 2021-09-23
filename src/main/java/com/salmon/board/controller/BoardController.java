package com.salmon.board.controller;


import com.salmon.board.domain.Board;
import com.salmon.board.domain.dto.BoardListResponseDto;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //Test
    @GetMapping("/hello")
    public String home(Model model){


        List<BoardListResponseDto> findBoardList = boardService.findAll();

        model.addAttribute("cnt", findBoardList);
        model.addAttribute("test", 2);

        return "hello";
    }

    //Create Rendering
    @GetMapping("/board/save")
    public String saveBoardRendering(){
        return "addForm";
    }

    //Create Post
    @PostMapping("/board/save")
    public String saveBoard(@RequestBody @ModelAttribute BoardRequestDto boardRequestDto){
        Board save = boardService.save(boardRequestDto);

        return "redirect:/board/List";
    }

    //Read One
    @GetMapping("/board")
    public BoardResponseDto readBoard(@RequestParam(value = "id", defaultValue = "0", required = true) Long id){
        System.out.println("id = " + id);
        BoardResponseDto findBoard = boardService.findById(id);

        return findBoard;
    }

    //Read List Rendering
    @GetMapping("/board/List")
    public String readBoardList(Model model){
        List<BoardListResponseDto> findBoardList = boardService.findAll();

        model.addAttribute("boardList", findBoardList);

        return "boardList";
    }

    //Update
    @PutMapping("/board")
    public Long updateBoard(@RequestParam(value = "id", required = true)Long id, @RequestBody BoardRequestDto boardRequestDto){
        System.out.println("id = " + id);
        System.out.println("boardRequestDto = " + boardRequestDto);

        Board updateBoard = boardService.update(id, boardRequestDto);
        return updateBoard.getId();
    }

    //Delete
    @DeleteMapping("/board")
    public Long deleteBoard(@RequestParam(value = "id", required = true)Long id){
        boardService.delete(id);
        return id;
    }

}
