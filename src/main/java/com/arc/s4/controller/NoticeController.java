package com.arc.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s4.model.BoardNoticeVO;
import com.arc.s4.model.BoardVO;
import com.arc.s4.service.BoardNoticeService;
import com.arc.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;

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
	public ModelAndView boardUpdate(BoardNoticeVO boardnoticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardUpdate(boardnoticeVO);
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
		BoardVO boardVO2 = boardNoticeService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.addObject("update", boardVO2);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		BoardVO boardVO2 = boardNoticeService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.addObject("select", boardVO2);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardWrite(boardVO, session);
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
