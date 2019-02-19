package com.iu.board;

import org.springframework.web.servlet.ModelAndView;

import com.iu.util.Pager;

public interface BoardService {
	
		//list
		public ModelAndView list(Pager pager) throws Exception;
		
		//select
		public ModelAndView select(int num) throws Exception;
		//insert
		public ModelAndView insert(BoardDTO boardDTO) throws Exception;
		//update
		public ModelAndView update(BoardDTO boardDTO) throws Exception;
		//delete
		public ModelAndView delete(int num) throws Exception;
	
}
