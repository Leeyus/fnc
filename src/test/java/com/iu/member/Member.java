package com.iu.member;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.fnc.AbstractTestCase;


public class Member extends AbstractTestCase{
	@Inject
	private MemberDAO memberDAO;

	@Test
	public void test() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("t3");
		memberDTO.setPw("t3");
		memberDTO.setName("t3");
		memberDTO.setNum_address(000);
		memberDTO.setMain_address("t3");
		memberDTO.setSub_address("t3");
		memberDTO.setPhone1("010");
		memberDTO.setPhone2("00000000");
		memberDTO.setEmail("t3@t3");
		memberDTO.setKind("u");
		int result=memberDAO.memberJoin(memberDTO);
		assertEquals(1, result);
		
	}
	

}
