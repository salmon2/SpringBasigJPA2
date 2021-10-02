package com.salmon.board.service;


import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import com.salmon.board.domain.User;
import com.salmon.board.domain.dto.BoardListResponseDto;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.domain.dto.BoardResponseDto;
import com.salmon.board.repository.BoardRepository;
import com.salmon.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.salmon.board.domain.Timestamped.TimeToString;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements  BoardService{

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


    //Create
    @Transactional
    public Board save(BoardRequestDto boardRequestDto, User user){
        Board newBoard = new Board(
                user.getUsername(),
                boardRequestDto.getTitle(),
                boardRequestDto.getContent(),
                user
        );

        Board save = boardRepository.save(newBoard);

        return save;
    }

    //Read All
    public List<BoardListResponseDto> findAll(){
        List<Board> findBoardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<BoardListResponseDto> boardListResponseDtoList = new ArrayList<>();

        for (Board board : findBoardList) {
            BoardListResponseDto newBoardListResponseDto =
                    new BoardListResponseDto(board.getId(), board.getTitle(),
                            board.getWriter(), TimeToString(board.getCreatedAt()));
            boardListResponseDtoList.add(newBoardListResponseDto);
        }

        return boardListResponseDtoList;
    }

    //Read One
    public BoardResponseDto findById(Long id){
        Optional<Board> optional = boardRepository.findById(id);
        Board findBoard = optional.get();

        List<Comment> findCommentList = commentRepository.findAllByBoard(findBoard);


        BoardResponseDto findBoardResponseDto = new BoardResponseDto(
                findBoard.getId(), findBoard.getTitle(), findBoard.getWriter(),
                findBoard.getContent(), TimeToString(findBoard.getCreatedAt()),
                findCommentList
        );

        return findBoardResponseDto;
    }

    //Update
    @Transactional
    public Board update(Long id, BoardRequestDto boardRequestDto){
        Optional<Board> optional = boardRepository.findById(id);
        Board findBoard = optional.get();

        findBoard.update(boardRequestDto);
        return findBoard;
    }

    //Delete
    @Transactional
    public void delete(Long id){
        boardRepository.deleteById(id);

    }

}
