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
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/actor/**")
public class ActorController {
	
	@Inject
	private ActorService actorService;
	
	@RequestMapping(value="actorList")
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = actorService.list(pager);
		mv.addObject("board", "actor");
		
		return mv;
	}
	@RequestMapping(value="actorSelect")
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = actorService.select(num);
		return mv;
	}
	
	//write Form
	@RequestMapping(value="actorWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "actor");
		return "board/boardWrite3";
	}
	
	//write process
	@RequestMapping(value="actorWrite", method=RequestMethod.POST)
	public ModelAndView write(ActorDTO actorDTO,HttpSession session, List<MultipartFile> f1, RedirectAttributes rd) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(realPath);
		
		ModelAndView mv = actorService.insert(actorDTO, f1, session);
		
		return mv;
	}
	@RequestMapping(value="actorUpdate",method=RequestMethod.GET)
	public ModelAndView update(int num)throws Exception{
		ModelAndView mv = actorService.select(num);
		mv.setViewName("board/boardUpdate3");
		return mv;
	}
	@RequestMapping(value="actorUpdate",method=RequestMethod.POST)
	public ModelAndView update(ActorDTO actorDTO,HttpSession session,List<MultipartFile>f1)throws Exception{
		ModelAndView mv = actorService.update(actorDTO, f1, session);
		return mv;
	}
	@RequestMapping(value="actorDelete",method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = actorService.delete(num, session);
		return mv;
	}

}
