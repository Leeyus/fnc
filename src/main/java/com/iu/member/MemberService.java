package com.iu.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	
	//delete
	public int delete(String id)throws Exception{
		return memberDAO.delete(id);
	}
	
	//findId
	
	
	//myPage
	public int update(MemberDTO memberDTO)throws Exception{
		return memberDAO.myPage(memberDTO);
	}
	
	
	//login
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	//idCheck
	public MemberDTO idCheck(String id) throws Exception{
		return memberDAO.idCheck(id);
	}
	
	
	//Join
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberJoin(memberDTO);
	}
	
	
}
