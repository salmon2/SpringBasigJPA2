package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Like;
import com.salmon.board.domain.User;
import com.salmon.board.repository.BoardRepository;
import com.salmon.board.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final BoardRepository boardRepository;

    @Override
    public Like save(Long boardId, User user) {
        Board findBoard = boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("등록된 아이디의 게시글이 없습니다.")
        );

        Like newLike = new Like(findBoard, user);

        Like saveLike = likeRepository.save(newLike);

        return saveLike;
    }
}
