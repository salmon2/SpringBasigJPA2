package com.salmon.board.service;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import com.salmon.board.domain.User;
import com.salmon.board.domain.UserRoleEnum;
import com.salmon.board.domain.dto.CommentRequestDto;
import com.salmon.board.repository.BoardRepository;
import com.salmon.board.repository.UserRepository;
import com.salmon.board.security.UserDetailsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CommentServiceImplTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentService commentService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("댓글 저장 테스트")
    @Transactional
    public void saveTest(){
        User testUser1 = new User("슈가1", passwordEncoder.encode("123"), "sugar1@sparta.com", UserRoleEnum.USER);
        User testUser2 = new User("슈가2", passwordEncoder.encode("123"), "sugar1@sparta.com", UserRoleEnum.USER);

        userRepository.save(testUser1);
        userRepository.save(testUser2);


        UserDetailsImpl newUserDetailsImpl = new UserDetailsImpl(testUser2);

        Board newBoard = new Board("new title ", "new contents ",  "writer ", testUser1);

        newBoard = boardRepository.save(newBoard);

        CommentRequestDto newComment = new CommentRequestDto(newBoard.getId(), "테스트 댓글 입니다.");
        Comment save = commentService.save(newComment, newUserDetailsImpl);
        System.out.println("save.getContents() = " + save.getContents());

    }
}