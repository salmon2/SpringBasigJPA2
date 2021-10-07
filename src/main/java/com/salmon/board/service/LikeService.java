package com.salmon.board.service;

import com.salmon.board.domain.Like;
import com.salmon.board.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    public Like save(Long boardId, User user);
}
