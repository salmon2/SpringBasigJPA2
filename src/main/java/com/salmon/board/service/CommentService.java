package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import com.salmon.board.domain.User;
import com.salmon.board.domain.dto.BoardListResponseDto;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.domain.dto.CommentRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    // Create
    public Comment save(CommentRequestDto commentRequestDto, Board board, User user);
    // Read All
    public List<CommentRequestDto> findAll();
    // Read One
    public Comment findById(Long id);
    // Update
    public Comment update(Long id, BoardRequestDto boardRequestDto);
    // Delete
    public void delete(Long id);

}
