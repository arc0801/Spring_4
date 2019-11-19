package com.arc.s4.service;

import javax.servlet.http.HttpSession;

import com.arc.s4.model.MemberVO;

public interface MemberService {
	
	//emailCheck
	public MemberVO memberEmailCheck(MemberVO memberVO) throws Exception;
	
	//IdCheck
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception;
	
	//join
	public int memberJoin(MemberVO memberVO, HttpSession session) throws Exception;
	
	//login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	//update
	public int memberUpdate(MemberVO memberVO) throws Exception;
	
	//delete
	public int memberDelete(MemberVO memberVO) throws Exception;
	
	//point update
	public int memberPointUpdate(MemberVO memberVO) throws Exception;
}
