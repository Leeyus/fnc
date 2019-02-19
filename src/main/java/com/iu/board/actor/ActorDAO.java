package com.iu.board.actor;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.board.release.ReleaseDTO;
import com.iu.util.Pager;
@Repository
public class ActorDAO implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESAPCE="actorMapper.";
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"getNum");
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESAPCE+"list", pager);
	}

	@Override
	public ActorDTO select(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESAPCE+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int insert(ActorDTO actorDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESAPCE+"insert", actorDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int update(ActorDTO actorDTO) throws Exception {
		
		return sqlSession.update(NAMESAPCE+"update", actorDTO);
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
