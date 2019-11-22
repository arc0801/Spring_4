package com.arc.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arc.s4.dao.BoardQnaDAO;
import com.arc.s4.dao.QnaFilesDAO;
import com.arc.s4.model.BoardVO;
import com.arc.s4.model.FilesVO;
import com.arc.s4.util.FileSaver;
import com.arc.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {

	@Inject
	private BoardQnaDAO boardQnaDAO;
	@Inject
	private QnaFilesDAO qnaFilesDAO;
	@Inject
	private FileSaver fileSaver;
	
	public FilesVO fileSelect(FilesVO filesVO) throws Exception {
		return qnaFilesDAO.fileSelect(filesVO);
	}
	
	public int fileDelete(FilesVO filesVO) throws Exception {
		return qnaFilesDAO.fileDelete(filesVO);
	}
	
	public int boardReply(BoardVO boardVO) throws Exception {
		boardQnaDAO.boardReplyUpdate(boardVO);
		
		return boardQnaDAO.boardReply(boardVO);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}
 
	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		//boardVO = boardQnaDAO.boardSelect(boardVO);
		
		//BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;
		
		//List<QnaFilesVO> ar = qnaFilesDAO.filesList(boardVO.getNum());
		
		//boardQnaVO.setFiles(ar);
		
		//return boardQnaVO;
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		int result = boardQnaDAO.boardWrite(boardVO);
		FilesVO filesVO = new FilesVO();
		filesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			if(multipartFile.getOriginalFilename()!="") {
				String fileName = fileSaver.save(realPath, multipartFile);
				filesVO.setFname(fileName);
				filesVO.setOname(multipartFile.getOriginalFilename());
				
				result = qnaFilesDAO.fileWrite(filesVO);
			}
		}
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		
		FilesVO qnaFilesVO = new FilesVO();
		qnaFilesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			if(multipartFile.getOriginalFilename()!="") {
				String fname = fileSaver.save(realPath, multipartFile);
				qnaFilesVO.setFname(fname);
				qnaFilesVO.setOname(multipartFile.getOriginalFilename());
				
				qnaFilesDAO.fileWrite(qnaFilesVO);
			}
		}
		
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardDelete(boardVO);
	}

}
