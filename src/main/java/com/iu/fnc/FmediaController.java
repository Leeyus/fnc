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
import com.iu.board.fmedia.FmediaDTO;
import com.iu.board.fmedia.FmediaService;
import com.iu.board.release.ReleaseDTO;
import com.iu.board.release.ReleaseService;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/fmedia/**")
public class FmediaController {
	@Inject
	private FmediaService fmediaService;
	
	
	@RequestMapping(value="fmediaList")
	public ModelAndView list(Pager pager)throws Exception{
		ModelAndView mv = fmediaService.list(pager);
		mv.addObject("board", "fmedia");
		
		return mv;
	}
	
	//select
	@RequestMapping(value="fmediaSelect")
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = fmediaService.select(num);
		return mv;
	}
	
	
	//write Form
			@RequestMapping(value="fmediaWrite", method=RequestMethod.GET)
			public String write(Model model) {
				model.addAttribute("board", "fmedia");
				return "board/boardWrite3";
			}
			
			//write process
			@RequestMapping(value="fmediaWrite", method=RequestMethod.POST)
			public ModelAndView write(FmediaDTO fmediaDTO,HttpSession session, List<MultipartFile> f1, RedirectAttributes rd) throws Exception {
				String realPath = session.getServletContext().getRealPath("resources/upload");
				System.out.println(realPath);
				
				ModelAndView mv = fmediaService.insert(fmediaDTO, f1, session);
				
				return mv;
			}
	//update Form
	@RequestMapping(value="fmediaUpdate",method=RequestMethod.GET)
	public ModelAndView update(int num)throws Exception{
		ModelAndView mv = fmediaService.select(num);
		mv.setViewName("board/boardUpdate3");
		return mv;
	}
	@RequestMapping(value="fmediaUpdate",method=RequestMethod.POST)
	public ModelAndView update(FmediaDTO fmediaDTO,HttpSession session,List<MultipartFile>f1)throws Exception{
		ModelAndView mv = fmediaService.update(fmediaDTO, f1, session);
		return mv;
	}
	@RequestMapping(value="fmediaDelete",method=RequestMethod.POST)
	public ModelAndView delete(int num, HttpSession session)throws Exception{
		ModelAndView mv = fmediaService.delete(num, session);
		return mv;
	}
	
	
	
}
