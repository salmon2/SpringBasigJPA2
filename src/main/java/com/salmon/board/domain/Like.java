package com.salmon.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "Like_")
public class Like {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Board board;

    @OneToOne
    private User user;

    public Like(Board board, User user) {
        this.board = board;
        this.user = user;
    }
}
