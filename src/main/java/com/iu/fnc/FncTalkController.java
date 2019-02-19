package com.iu.fnc;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.fncTalk.FncTalkService;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/fncTalk/**")
public class FncTalkController {
	@Inject
	private FncTalkService fncTalkService;
	
	
	@RequestMapping(value="fncTalkList")
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = fncTalkService.list(pager);
		mv.addObject("board", "fncTalk");
		return mv;
	}
	@RequestMapping(value="fncTalkSelect")
	public ModelAndView select(int num) throws Exception{
		ModelAndView mv = fncTalkService.select(num);
		return mv;
	}
	@RequestMapping(value="fncTalkWrite",method=RequestMethod.GET)
	public String insert(Model model)throws Exception{
		model.addAttribute("board", "fncTalk");
		return"board/boardWrite2";
	}
	@RequestMapping(value="fncTalkWrite",method=RequestMethod.POST)
	public ModelAndView insert(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = fncTalkService.insert(boardDTO);
		return mv;
	}
	@RequestMapping(value="fncTalkUpdate",method=RequestMethod.GET)
	public ModelAndView update(int num)throws Exception{
		ModelAndView mv = fncTalkService.select(num);
		mv.setViewName("board/boardUpdate2");
		return mv;
	}
	@RequestMapping(value="fncTalkUpdate", method=RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO) throws Exception{
		ModelAndView mv=fncTalkService.update(boardDTO);
		return mv;
	}
	@RequestMapping(value="fncTalkDelete",method=RequestMethod.POST)
	public ModelAndView delete(int num)throws Exception{
		ModelAndView mv = fncTalkService.delete(num);
		return mv;
	}
	
	
	
}
