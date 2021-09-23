package com.salmon.board.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BoardListResponseDto {
    private String title;
    private String writer;
    private String createdAt;
}
