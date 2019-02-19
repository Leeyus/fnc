package com.iu.board.singer;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.board.actor.ActorDTO;
import com.iu.util.Pager;
import com.iu.util.Pager2;

@Repository
public class SingerDAO implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESAPCE="singerMapper.";
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"getNum");
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		return null;
	}
	public List<BoardDTO> list(Pager2 pager2) throws Exception {
		
		return sqlSession.selectList(NAMESAPCE+"list", pager2);
	}

	@Override
	public SingerDTO select(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int insert(SingerDTO singerDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESAPCE+"insert", singerDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int update(SingerDTO singerDTO) throws Exception {
		
		return sqlSession.update(NAMESAPCE+"update", singerDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESAPCE+"delete", num);
	}

	@Override
	public int totalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int totalCount(Pager2 pager2) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"totalCount", pager2);
	}


}
