package com.salmon.board.service;

import com.salmon.board.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    public String likeUpOrDown(Long boardId, User user) ;
}
