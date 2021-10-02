package com.salmon.board.repository;


import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoard(Board findBoard);
}
