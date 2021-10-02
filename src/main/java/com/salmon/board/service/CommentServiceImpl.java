package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import com.salmon.board.domain.User;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.domain.dto.CommentRequestDto;

import java.util.List;

public class CommentServiceImpl implements  CommentService{

    @Override
    public Comment save(CommentRequestDto commentRequestDto, Board board, User user) {
        return null;
    }

    @Override
    public List<CommentRequestDto> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public Comment update(Long id, BoardRequestDto boardRequestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
