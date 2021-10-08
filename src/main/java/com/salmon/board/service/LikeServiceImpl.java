package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Like;
import com.salmon.board.domain.User;
import com.salmon.board.exception.AlreadyLikeUpException;
import com.salmon.board.repository.BoardRepository;
import com.salmon.board.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final BoardRepository boardRepository;

    @Override
    public String likeUpOrDown(Long boardId, User user) throws AlreadyLikeUpException {
        Board findBoard = boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("등록된 아이디의 게시글이 없습니다.")
        );

        List<Like> findDuplicateLike = likeRepository.findAllByBoardAndUser(findBoard, user);

        if(findDuplicateLike.size() != 0){
            Like findLike = findDuplicateLike.get(0);
            likeRepository.delete(findLike);
            return "좋아요를 취소하였습니다.";
        }
        else{
            Like newLike = new Like(findBoard, user);

            Like saveLike = likeRepository.save(newLike);
            return "좋아요를 완료하였습니다.";
        }

    }
}
