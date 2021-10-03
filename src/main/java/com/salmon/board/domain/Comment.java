package com.salmon.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salmon.board.domain.dto.CommentRequestDto;
import com.salmon.board.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    @JsonIgnore
    private Board board;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Comment(String contents, Board board, User user) {
        this.contents = contents;
        this.board = board;
        this.user = user;
    }

    public Comment update(CommentRequestDto commentRequestDto) {
        this.contents = commentRequestDto.getContents();
        return this;
    }
}
