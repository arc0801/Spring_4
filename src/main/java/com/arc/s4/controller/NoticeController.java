package com.arc.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s4.model.BoardNoticeVO;
import com.arc.s4.model.BoardVO;
import com.arc.s4.model.NoticeFilesVO;
import com.arc.s4.service.BoardNoticeService;
import com.arc.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(NoticeFilesVO noticeFilesVO) throws Exception {
		noticeFilesVO = boardNoticeService.fileSelect(noticeFilesVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("file", noticeFilesVO);
		mv.addObject("board", "notice");
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(NoticeFilesVO noticeFilesVO) throws Exception {
		//System.out.println(noticeFilesVO.getFnum());
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.fileDelete(noticeFilesVO);
		
		if(result>0) {
			mv.addObject("msg", "Delete Success");
		}else {
			mv.addObject("msg", "Delete Fail");
		}
		mv.addObject("result", result);
		mv.addObject("path", "notice/noticeList");
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
	}
	
	@RequestMapping("noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "Delete Success");
		}else {
			mv.addObject("msg", "Delete Fail");
		}
		mv.addObject("path", "notice/noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardUpdate(boardVO, file, session);
		
		if(result>0) {
			mv.addObject("msg", "Update Success");
		}else {
			mv.addObject("msg", "Update Fail");
		}
		mv.addObject("path", "notice/noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeUpdate")
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO2 = boardNoticeService.boardSelect(boardVO);
		
		if(boardVO2 != null) {
			BoardNoticeVO noticeVO = (BoardNoticeVO)boardVO2;
			int size = noticeVO.getFiles().size();
			mv.addObject("size", size);
			mv.addObject("board", "notice");
			mv.addObject("update", boardVO2);
			mv.setViewName("board/boardUpdate");
		}else {
			mv.addObject("msg", "No Contents");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		boardVO = boardNoticeService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		
		if(boardVO != null) {
			boardVO.setContents(boardVO.getContents().replace("\r\n", "<br>"));
			mv.addObject("board", "notice");
			mv.addObject("select", boardVO);
			mv.setViewName("board/boardSelect");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		/*
		for(int i=0;i<file.length;i++) {
			//배열은 length, arraylist는 size
			System.out.println(file[i].getOriginalFilename());
		}
		*/
		
		int result = boardNoticeService.boardWrite(boardVO, file, session);
		if(result>0) { 
			mv.addObject("msg", "WriteSuccess");
			//mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "WriteFail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeWrite")
	public ModelAndView boardWrite() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
