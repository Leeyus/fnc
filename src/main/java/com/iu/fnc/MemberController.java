package com.iu.fnc;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	@Inject
	private MemberService memberService;
	
	
	//delete
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(HttpSession session, RedirectAttributes rd)throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result=memberService.delete(memberDTO.getId());
		String message="Delete Fail";
		if(result>0) {
			message="Delete Success";
			session.invalidate();//로그아웃을 해주는것
		}
		rd.addFlashAttribute("msg", message);
		return "redirect:../";
	}
	
	
	//마이페이지
	@RequestMapping(value="myPage",method=RequestMethod.GET)
	public void myPage()throws Exception{
		
	}
	
	//마이페이지 post
	@RequestMapping(value="myPage",method=RequestMethod.POST)
	public ModelAndView myPage(MemberDTO memberDTO, HttpSession session/*,RedirectAttributes rd*/)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO sMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sMemberDTO.getId());
		System.out.println(memberDTO.getId());
		int result=memberService.update(memberDTO);
		String path="";
		if(result>0) {
			memberDTO.setKind(sMemberDTO.getKind());
			session.setAttribute("dto", memberDTO);
			//rd.addFlashAttribute("msg", "수정을 성공적으로했습니다");
			//path="redirect:../";
			mv.setViewName("redirect:../");
			mv.addObject("msg", "수정을 성공적으로 했습니다.");
		}else {
			//rd.addFlashAttribute("msg", "수정실패했습니다");
			//path="redirect:./myPage";
			mv.setViewName("redirect:./myPage");
			mv.addObject("msg", "수정을 실패했습니다");
		}
		return mv;
	}
	
	//id찾기폼
	@RequestMapping(value="findId", method=RequestMethod.GET)
	public void findId()throws Exception{}
	
	//findId처리
	
	
	
	//로그인 폼
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login()throws Exception{}
	
	//login
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(MemberDTO memberDTO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO=memberService.login(memberDTO);
		//String path="";
		int result=0;
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			//path="home";
			result=1;
			
		}else {
			//path="./login";
			System.out.println("fail");
			//rd.addFlashAttribute("msg", "로그인 실패");
			result=0;
		}
		mv.addObject("result", result);
		mv.addObject("msg", "로그인 실패");
		mv.setViewName("/common/result");
		return mv;
		
	}
	//로그아웃처리
	@RequestMapping(value="logOut")
	public String logOut(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	
	//약관동의
	@RequestMapping(value="consent", method=RequestMethod.GET)
	public void consent()throws Exception{}
	
	//idCheck
	@RequestMapping(value="idCheck")
	public String idCheck(String id, Model model) throws Exception{
		MemberDTO memberDTO = memberService.idCheck(id);
		int result2 = 0;
		if(memberDTO == null) {
			result2=1;
		}
		model.addAttribute("result", result2);
		
		return "common/result2";
	}
	
	
	//회원가입
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void memberJoin()throws Exception{}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO,RedirectAttributes rd) throws Exception{
		memberDTO.setKind("u");
		int result = memberService.memberJoin(memberDTO);
		
		String path="redirect:../";
		if(result<1) {
			path="redirect:./memberJoin";
			rd.addFlashAttribute("msg", "회원가입 실패");
			
		}
		
		return path;
	}

}
