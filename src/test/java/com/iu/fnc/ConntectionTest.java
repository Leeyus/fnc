package com.iu.fnc;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.member.MemberDAO;

public class ConntectionTest  extends AbstractTestCase{
	@Inject
	SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession);
		
	}

}
