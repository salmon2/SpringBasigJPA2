package com.salmon.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salmon.board.domain.dto.BoardRequestDto;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long Id;

    private String title;

    private String content;

    private String writer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private User user;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board(String title, String content, String writer, User user) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.user = user;
    }

    //update
    public Board update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();

        return this;
    }
}