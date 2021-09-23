package com.salmon.board.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardListResponseDto {
    private Long id;

    private String title;
    private String writer;
    private String createdAt;
}
