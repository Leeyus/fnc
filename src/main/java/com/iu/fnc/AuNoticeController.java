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
import com.iu.board.auNotice.AuNoticeService;
import com.iu.board.notice.NoticeService;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/auNotice/**")
public class AuNoticeController {

	@Inject
	private AuNoticeService auNoticeService;
	
	
	//list
		@RequestMapping(value="AuditionNoticeList")
		public ModelAndView list(Pager pager) throws Exception {
			
			//System.out.println(curPage);
			ModelAndView mv = auNoticeService.list(pager);
			mv.addObject("board", "AuditionNotice");
			return mv;
		}
		//select
		@RequestMapping(value="AuditionNoticeSelect")
		public ModelAndView select(int num) throws Exception{
			ModelAndView mv = auNoticeService.select(num);
			
			return mv;
		}
		
		
		//write Form
		@RequestMapping(value="AuditionNoticeWrite", method=RequestMethod.GET)
		public String write(Model model) {
			model.addAttribute("board", "AuditionNotice");
			return "board/boardWrite";
		}
		
		//write process
		@RequestMapping(value="AuditionNoticeWrite", method=RequestMethod.POST)
		public ModelAndView write(BoardDTO boardDTO,HttpSession session, List<MultipartFile> f1, RedirectAttributes rd) throws Exception {
			String realPath = session.getServletContext().getRealPath("resources/upload");
			System.out.println(realPath);
			
			ModelAndView mv = auNoticeService.insert(boardDTO, f1, session);
			
			return mv;
		}
		@RequestMapping(value="AuditionNoticeUpdate", method=RequestMethod.GET)
		public ModelAndView update(int num)throws Exception {
			ModelAndView mv=auNoticeService.select(num);
			mv.setViewName("board/boardUpdate");
			return mv;
		}
		//update process
		@RequestMapping(value="AuditionNoticeUpdate", method=RequestMethod.POST)
		public ModelAndView update(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
			ModelAndView mv=auNoticeService.update(boardDTO, f1,session);
			
			return mv;
		}
		
		//delete process
		@RequestMapping(value="AuditionNoticeDelete", method=RequestMethod.POST)
		public ModelAndView delete(int num,HttpSession session) throws Exception{
			ModelAndView mv=auNoticeService.delete(num, session);
			return mv;
		}
	
}
