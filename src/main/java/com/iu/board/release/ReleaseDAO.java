package com.iu.board.release;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.Pager;
@Repository
public class ReleaseDAO implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="releaseMapper.";
	
	
	public int getNum()throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}

	@Override
	public int totalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"totalCount", pager);
	}
	
	@Override
	public ReleaseDTO select(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int insert(ReleaseDTO releaseDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"insert", releaseDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public int update(ReleaseDTO releaseDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update", releaseDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"delete", num);
	}


}
