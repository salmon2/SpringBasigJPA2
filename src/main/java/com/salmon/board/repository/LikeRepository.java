package com.salmon.board.repository;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Like;
import com.salmon.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findAllByBoard(Board board);
    List<Like> findAllByBoardAndUser(Board board, User user);
}
