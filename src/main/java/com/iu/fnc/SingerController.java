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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.iu.board.BoardDTO;
import com.iu.board.actor.ActorDTO;
import com.iu.board.actor.ActorService;
import com.iu.board.release.ReleaseDTO;
import com.iu.board.singer.SingerDTO;
import com.iu.board.singer.SingerService;
import com.iu.util.Pager;
import com.iu.util.Pager2;

@Controller
@RequestMapping(value="/singer/**")
public class SingerController {
	
	@Inject
	private SingerService singerServic;
	
	@RequestMapping(value="singerList")
	public ModelAndView list(Pager2 pager2)throws Exception{
		ModelAndView mv = singerServic.list(pager2);
		mv.addObject("board", "singer");
		
		return mv;
	}
	@RequestMapping(value="singerSelect")
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = singerServic.select(num);
		return mv;
	}
	
	//write Form
	@RequestMapping(value="singerWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "singer");
		return "board/boardWrite4";
	}
	
	//write process
	@RequestMapping(value="singerWrite", method=RequestMethod.POST)
	public ModelAndView write(SingerDTO singerDTO,HttpSession session, List<MultipartFile> f1, RedirectAttributes rd) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(realPath);
		
		ModelAndView mv = singerServic.insert(singerDTO, f1, session);
		
		return mv;
	}
	@RequestMapping(value="singerUpdate",method=RequestMethod.GET)
	public ModelAndView update(int num)throws Exception{
		ModelAndView mv = singerServic.select(num);
		mv.setViewName("board/boardUpdate3");
		return mv;
	}
	@RequestMapping(value="singerUpdate",method=RequestMethod.POST)
	public ModelAndView update(SingerDTO singerDTO,HttpSession session,List<MultipartFile>f1)throws Exception{
		ModelAndView mv = singerServic.update(singerDTO, f1, session);
		return mv;
	}
	@RequestMapping(value="singerDelete",method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = singerServic.delete(num, session);
		return mv;
	}

}
