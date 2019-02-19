package com.iu.board.fncTalk;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.util.Pager;

@Service
public class FncTalkService {
	@Inject
	private FncTalkDAO fncTalkDAO;
	
	public ModelAndView list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = fncTalkDAO.totalCount(pager);
		pager.makePage(totalCount);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("board/boardList2");
		mv.addObject("list", fncTalkDAO.list(pager));
		mv.addObject("pager", pager);
		
		return mv;
	}
	
	public ModelAndView select(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = fncTalkDAO.select(num);
		if(boardDTO!=null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
		}else {
			mv.setViewName("redirect:./fncTalkList");
		}
		mv.addObject("board", "fncTalk");
		return mv;
	}
	
	public ModelAndView insert(BoardDTO boardDTO)throws Exception{
		int num = fncTalkDAO.getNum();
		boardDTO.setNum(num);
		int result = fncTalkDAO.insert(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./fncTalkList");
		return mv;
	}
	public ModelAndView update(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = fncTalkDAO.update(boardDTO);
		mv.setViewName("redirect:./fncTalkSelect?num="+boardDTO.getNum());
		return mv;
	}
	public ModelAndView delete(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = fncTalkDAO.delete(num);
		mv.setViewName("redirect:./fncTalkList");
		return mv;
	}
	

}
