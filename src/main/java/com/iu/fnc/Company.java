package com.iu.fnc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/company/**")
public class Company {
	
	@RequestMapping(value="aboutFnc")
	public void aboutFnc()throws Exception{}
	
	@RequestMapping(value="business")
	public void business()throws Exception{}
	
	@RequestMapping(value="loveFnc")
	public void loveFnc()throws Exception{}
	
	//AUDITION
	@RequestMapping(value="information")
	public void information()throws Exception{}
	@RequestMapping(value="faq")
	public void faq()throws Exception{}

}
