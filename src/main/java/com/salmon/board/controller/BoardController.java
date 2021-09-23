package com.salmon.board.controller;


import com.salmon.board.domain.Board;
import com.salmon.board.domain.dto.BoardListResponseDto;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //Test
    @GetMapping("/hello")
    public String home(Model model){
        model.addAttribute("cnt", 1);
        model.addAttribute("test", 2);

        return "hello";
    }

    //Create
    @PostMapping("/board")
    public Long saveBoard(@RequestBody BoardRequestDto boardRequestDto){
        Board save = boardService.save(boardRequestDto);
        return save.getId();
    }

    //Read One
    @GetMapping("/board")
    public BoardResponseDto readBoard(@RequestParam(value = "id", defaultValue = "0", required = true) Long id){
        System.out.println("id = " + id);
        BoardResponseDto findBoard = boardService.findById(id);

        return findBoard;
    }

    //Read List
    @GetMapping("/board/List")
    public List<BoardListResponseDto> readBoardList(){
        List<BoardListResponseDto> findBoardList = boardService.findAll();
        return findBoardList;
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
