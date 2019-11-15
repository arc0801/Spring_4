package com.arc.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.arc.s4.dao.MemberDAOImpl;
import com.arc.s4.model.MemberVO;

public class MemberDAOImplTest extends TestAbstractCase {

	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	@Test
	public void memberUpdateTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setPw("b");
		memberVO.setName("b");
		memberVO.setEmail("b");
		memberVO.setBirth("1995-02-02");
		memberVO.setId("a");
		
		int result = memberDAOImpl.memberUpdate(memberVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void memberJoinTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("a");
		memberVO.setPw("a");
		memberVO.setName("a");
		memberVO.setEmail("a");
		memberVO.setBirth("1995-01-01");
		memberVO.setGender("F");
		
		int result = memberDAOImpl.memberJoin(memberVO);
		
		assertEquals(1, result);
	}

}
