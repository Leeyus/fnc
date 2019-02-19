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
import com.iu.board.entertainer.EntertainerDTO;
import com.iu.board.entertainer.EntertainerService;
import com.iu.board.release.ReleaseDTO;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/entertainer/**")
public class EntertainerController {
	
	@Inject
	private EntertainerService entertainerService;
	
	@RequestMapping(value="entertainerList")
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = entertainerService.list(pager);
		mv.addObject("board", "entertainer");
		
		return mv;
	}
	@RequestMapping(value="entertainerSelect")
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = entertainerService.select(num);
		return mv;
	}
	
	//write Form
	@RequestMapping(value="entertainerWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "entertainer");
		return "board/boardWrite3";
	}
	
	//write process
	@RequestMapping(value="entertainerWrite", method=RequestMethod.POST)
	public ModelAndView write(EntertainerDTO entertainerDTO,HttpSession session, List<MultipartFile> f1, RedirectAttributes rd) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(realPath);
		
		ModelAndView mv = entertainerService.insert(entertainerDTO, f1, session);
		
		return mv;
	}
	@RequestMapping(value="entertainerUpdate",method=RequestMethod.GET)
	public ModelAndView update(int num)throws Exception{
		ModelAndView mv = entertainerService.select(num);
		mv.setViewName("board/boardUpdate3");
		return mv;
	}
	@RequestMapping(value="entertainerUpdate",method=RequestMethod.POST)
	public ModelAndView update(EntertainerDTO entertainerDTO,HttpSession session,List<MultipartFile>f1)throws Exception{
		ModelAndView mv = entertainerService.update(entertainerDTO, f1, session);
		return mv;
	}
	@RequestMapping(value="entertainerDelete",method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = entertainerService.delete(num, session);
		return mv;
	}

}
