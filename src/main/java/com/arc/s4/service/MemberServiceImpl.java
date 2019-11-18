package com.arc.s4.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.arc.s4.dao.MemberDAOImpl;
import com.arc.s4.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	@Override
	public MemberVO memberEmailCheck(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberEmailCheck(memberVO);
	}
	
	@Override
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberIdCheck(memberVO);
	}
	
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberJoin(memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberLogin(memberVO);
	}

	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberUpdate(memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberDelete(memberVO);
	}

	@Override
	public int memberPointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
