package com.arc.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s4.model.BoardQnaVO;
import com.arc.s4.model.BoardVO;
import com.arc.s4.service.BoardQnaService;
import com.arc.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView boardReply(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardReply(boardVO);
		if(result>0) {
			mv.addObject("msg", "Reply Write Success");
		}else {
			mv.addObject("msg", "Reply Write Fail");
		}
		mv.addObject("path", "qna/qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("qnaReply")
	public ModelAndView boardReplyForm(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("num", boardVO.getNum());
		mv.addObject("board", "qna");
		mv.setViewName("board/boardReply");
		
		return mv;
	}
	
	@RequestMapping("qnaDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "Delete Success");
		}else {
			mv.addObject("msg", "Delete Fail");
		}
		mv.addObject("path", "qna/qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardQnaVO boardQnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardUpdate(boardQnaVO);
		if(result>0) {
			mv.addObject("msg", "Update Success");
		}else {
			mv.addObject("msg", "Update Fail");
		}
		mv.addObject("path", "qna/qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("qnaUpdate")
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		BoardVO boardVO2 = boardQnaService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.addObject("update", boardVO2);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping("qnaSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		BoardVO boardVO2 = boardQnaService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.addObject("select", boardVO2);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardWrite(boardVO);
		if(result>0) {
			mv.addObject("msg", "WriteSuccess");
		}else {
			mv.addObject("msg", "WriteFail");
		}
		mv.addObject("path", "qnaList"); 
		//path로 qnaList를 받았으므로 다시 Controll로 들어와서 qnaList 메서드 실행
		//mv.addObject("board", "qna"); 필요없음
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("qnaWrite")
	public ModelAndView boardWrite() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping("qnaList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> ar = boardQnaService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		
		BoardVO boardVO = new BoardQnaVO();
		//boardVO는 부모타입이니까 자식타입 BoardQnaVO를 담을 수 있다
		BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;
		//데이터를 꺼내오려면 부모타입을 자식타입으로 형변환해줘야 함
		boardQnaVO.getRef();
		
		return mv;
	}
}
