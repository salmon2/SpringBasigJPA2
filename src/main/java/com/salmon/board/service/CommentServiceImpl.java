package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import com.salmon.board.domain.User;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.domain.dto.CommentRequestDto;
import com.salmon.board.repository.BoardRepository;
import com.salmon.board.repository.CommentRepository;
import com.salmon.board.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements  CommentService{
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public Comment save(CommentRequestDto commentRequestDto, UserDetailsImpl userDetails) {
        Board findBoard = boardRepository.findById(commentRequestDto.getBoardId()).orElseThrow(
                () -> new NullPointerException("같은 아이디의 게시글이 없습니다.")
        );

        Comment newComment = new Comment(commentRequestDto.getContents(), findBoard, userDetails.getUser());

        Comment saveComment = commentRepository.save(newComment);

        return saveComment;
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
