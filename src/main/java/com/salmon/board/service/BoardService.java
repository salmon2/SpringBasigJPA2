package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.User;
import com.salmon.board.domain.dto.BoardListResponseDto;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.salmon.board.domain.Timestamped.TimeToString;

public interface BoardService {
    // Create
    public Board save(BoardRequestDto boardRequestDto, User user);
    // Read All
    public List<BoardListResponseDto> findAll();
    // Read One
    public BoardResponseDto findById(Long id);
    // Update
    public Board update(Long id, BoardRequestDto boardRequestDto);
    // Delete
    public void delete(Long id);

}
