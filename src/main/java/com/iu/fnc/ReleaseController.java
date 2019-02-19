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
import com.iu.board.release.ReleaseDTO;
import com.iu.board.release.ReleaseService;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/release/**")
public class ReleaseController {
	@Inject
	private ReleaseService releaseService;
	
	
	@RequestMapping(value="releaseList")
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = releaseService.list(pager);
		mv.addObject("board", "release");
		
		return mv;
	}
	
	//select
	@RequestMapping(value="releaseSelect")
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = releaseService.select(num);
		return mv;
	}
	
	
	//write Form
			@RequestMapping(value="releaseWrite", method=RequestMethod.GET)
			public String write(Model model) {
				model.addAttribute("board", "release");
				return "board/boardWrite3";
			}
			
			//write process
			@RequestMapping(value="releaseWrite", method=RequestMethod.POST)
			public ModelAndView write(ReleaseDTO releaseDTO,HttpSession session, List<MultipartFile> f1, RedirectAttributes rd) throws Exception {
				String realPath = session.getServletContext().getRealPath("resources/upload");
				System.out.println(realPath);
				
				ModelAndView mv = releaseService.insert(releaseDTO, f1, session);
				
				return mv;
			}
	//update Form
	@RequestMapping(value="releaseUpdate",method=RequestMethod.GET)
	public ModelAndView update(int num)throws Exception{
		ModelAndView mv = releaseService.select(num);
		mv.setViewName("board/boardUpdate3");
		return mv;
	}
	@RequestMapping(value="releaseUpdate",method=RequestMethod.POST)
	public ModelAndView update(ReleaseDTO releaseDTO,HttpSession session,List<MultipartFile>f1)throws Exception{
		ModelAndView mv = releaseService.update(releaseDTO, f1, session);
		return mv;
	}
	@RequestMapping(value="releaseDelete",method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = releaseService.delete(num, session);
		return mv;
	}
	
	
	
}
