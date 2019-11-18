package com.arc.s4.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arc.s4.model.MemberVO;
import com.arc.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Inject
	private MemberServiceImpl memberServiceImpl;
	
	@GetMapping("memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberDelete(memberVO);
		String msg = "Delete Fail";
		if(result>0) {
			msg = "Delete Success";
			mv.addObject("msg", msg);
		}
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberUpdate(memberVO);
		String msg = "Update Fail";
		
		if(result>0) {
			msg = "Update Success";
			mv.addObject("msg", msg);
			session.setAttribute("member", memberVO);
		}
		mv.addObject("path", "memberMypage");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@GetMapping("memberUpdate")
	public void memberUpdate() throws Exception {
		
	}
	
	@GetMapping("memberMypage")
	public void memberMypage(HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = transFormat.parse(memberVO.getBirth());
		String to = transFormat.format(birth);
		memberVO.setBirth(to);
		session.setAttribute("member", memberVO);
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		//session.removeAttribute("member");
		session.invalidate(); //session의 시간 강제로 0으로 변경
		
		return "redirect:../";
	}
	
	@PostMapping("memberLogin")
	public String memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberServiceImpl.memberLogin(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO); //로그인은 Model이 아니라 Session에서!!
		}
		
		return "redirect:../";
	}
	
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {
		
	}
	
	@GetMapping("memberIdCheck")
	public void memberIdCheck(MemberVO memberVO, Model model) throws Exception {
		memberVO = memberServiceImpl.memberIdCheck(memberVO);
		String result = "unpass";
		
		if(memberVO == null) {
			result = "pass";
		}
		
		model.addAttribute("result", result);
	}
	
	@PostMapping("memberEmailCheck")
	public void memberEmailCheck(MemberVO memberVO, Model model) throws Exception {
		memberVO = memberServiceImpl.memberEmailCheck(memberVO);
		String result = "unpass";

		if(memberVO == null) {
			result = "pass";
		}

		model.addAttribute("result", result);
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberJoin(memberVO);
		
		if(result>0) {
			mv.addObject("msg", "Join Success");
		}else {
			mv.addObject("msg", "Join Fail");
		}
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@GetMapping("memberJoin")
	public void memberJoin() throws Exception {
		
	}
	
}
