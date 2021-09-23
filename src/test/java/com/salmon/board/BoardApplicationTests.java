package com.salmon.board;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.dto.BoardRequestDto;
import com.salmon.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class BoardApplicationTests {
	@Autowired
	private BoardService boardService;

	@Test
	public void saveTest() throws Exception{
	    //given
	    BoardRequestDto boardRequestDto = new BoardRequestDto("test title", "test content");

	    //when
		Board saveBoard = boardService.save(boardRequestDto);

		//then
		boardService.findById(saveBoard.getId());
		System.out.println("saveBoard = " + saveBoard);

	}

}
