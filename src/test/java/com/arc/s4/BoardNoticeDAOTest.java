package com.arc.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.arc.s4.dao.BoardNoticeDAO;
import com.arc.s4.model.BoardVO;

public class BoardNoticeDAOTest extends TestAbstractCase {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Test
	public void boardDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(207);
		
		int result = boardNoticeDAO.boardDelete(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void boardUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test2");
		boardVO.setContents("test2");
		boardVO.setNum(207);
		
		int result = boardNoticeDAO.boardUpdate(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void boardSelectTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(205);
		boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		assertNotNull(boardVO);
	}
	
	//@Test
	public void boardWriteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test");
		boardVO.setContents("test");
		boardVO.setWriter("test");
		int result = boardNoticeDAO.boardWrite(boardVO);
		
		assertEquals(1, result);
	}

}
