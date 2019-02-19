package com.iu.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="memberMapper.";
	
	//delete
	public int delete(String id)throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", id);
	}
	
	//myPage
	public int myPage(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update", memberDTO);
	}
	
	//login
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	
	//중복
	public MemberDTO idCheck(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"idCheck", id);
	}
	
	//회원가입
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}

}
