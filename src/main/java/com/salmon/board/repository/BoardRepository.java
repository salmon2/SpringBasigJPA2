package com.salmon.board.repository;

import com.salmon.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
