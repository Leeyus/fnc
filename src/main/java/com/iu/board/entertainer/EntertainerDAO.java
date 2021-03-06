package com.iu.board.entertainer;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.board.release.ReleaseDTO;
import com.iu.util.Pager;
@Repository
public class EntertainerDAO implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESAPCE="entertainerMapper.";
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"getNum");
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESAPCE+"list", pager);
	}

	@Override
	public EntertainerDTO select(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int insert(EntertainerDTO entertainerDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESAPCE+"insert", entertainerDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int update(EntertainerDTO entertainerDTO) throws Exception {
		
		return sqlSession.update(NAMESAPCE+"update", entertainerDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESAPCE+"delete", num);
	}

	@Override
	public int totalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"totalCount", pager);
	}

}
