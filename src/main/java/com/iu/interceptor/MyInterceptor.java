/*package com.iu.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeDTO;
import com.iu.member.MemberDTO;

public class MyInterceptor extends HandlerInterceptorAdapter {
	
	
	//controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//return이 true면 controller로 이동
		//return이false면 controller 이동X
		
		System.out.println(request.getPathInfo());
		HttpSession session = request.getSession();
		boolean check = false;
		if(session.getAttribute("member")!=null) {
			check=true;
		}else {
			response.sendRedirect("../member/login");
		}
		
		return check;
	}
	
	
	//controller 완료 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String m = request.getMethod();
		if(m.equals("GET")) {
		
			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			Map<String, Object> map = modelAndView.getModel();
			BoardDTO boardDTO = (BoardDTO)map.get("dto");
			
			if(memberDTO==null || !memberDTO.getId().equals(boardDTO.getName())) {
				String board = (String)map.get("board");
				modelAndView.setViewName("redirect:./"+board+"List");
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
*/