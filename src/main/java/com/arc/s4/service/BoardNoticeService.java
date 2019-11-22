package com.arc.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arc.s4.dao.BoardNoticeDAO;
import com.arc.s4.dao.NoticeFilesDAO;
import com.arc.s4.model.BoardNoticeVO;
import com.arc.s4.model.BoardVO;
import com.arc.s4.model.FilesVO;
import com.arc.s4.util.FileSaver;
import com.arc.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	//@Inject
	//private HttpSession session;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	public String summerFile(MultipartFile file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/summerFile");
		return fileSaver.save(realPath, file);
	}
	
	public FilesVO fileSelect(FilesVO filesVO) throws Exception {
		return noticeFilesDAO.fileSelect(filesVO);
	}
	
	public int fileDelete(FilesVO filesVO) throws Exception {
		return noticeFilesDAO.fileDelete(filesVO);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		//boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		
		//List<NoticeFilesVO> ar = noticeFilesDAO.fileList(boardVO.getNum());
		
		//boardNoticeVO.setFiles(ar);
		
		//return boardNoticeVO;
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		FilesVO noticeFilesVO = new FilesVO();
		int result = boardNoticeDAO.boardWrite(boardVO);
		//System.out.println(boardVO.getNum());
		noticeFilesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			if(multipartFile.getOriginalFilename()!="") {
				//multipartFile.getSize()!=0
				String fileName = fileSaver.save(realPath, multipartFile);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
				
				result = noticeFilesDAO.fileWrite(noticeFilesVO);
			}
		}
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		FilesVO noticeFilesVO = new FilesVO();
		noticeFilesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			if(multipartFile.getOriginalFilename()!="") {
				String fileName = fileSaver.save(realPath, multipartFile);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
				
				noticeFilesDAO.fileWrite(noticeFilesVO);
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		return boardNoticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
