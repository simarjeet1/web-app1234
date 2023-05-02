package com.ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.MyTshirtDao;
import com.dao.Userdao;
import com.entities.AppUser;
import com.entities.MyTshirt;
import com.utilityClasses.MyCSVParser;
import com.utilityClasses.MyFileChangeThread;

@Controller
public class HomeCtrl {
	
	@Autowired
	MyTshirtDao tdao;
	
	@Autowired
	Userdao udao;
	
	@Autowired
	MyFileChangeThread fct;
	
	@RequestMapping("/home")
	public String home() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		if((this.udao.getUserDetailsByEmailAndPassword(req.getParameter("username"), req.getParameter("password")))!=null) {
			
			System.out.println("Successfully logged in");
			ArrayList<MyTshirt> al=MyCSVParser.parseCSVFiles();
			System.out.println(al.size());
			for(MyTshirt tee: al) {
				this.tdao.save(tee);
			}
			session.setAttribute("currentUser", req.getParameter("username"));
			mv.setViewName("searchPage");
			mv.addObject("currentUser", req.getParameter("username"));
//			fct.start();
			return mv;
		}
		else return mv;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(HttpServletRequest req,HttpServletResponse res) {
		AppUser user=new AppUser("simarjeet123","qwerty");
		this.udao.save(user);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		
		return mv;
		
		
	}
	
	@RequestMapping("/searchTshirts")
	public ModelAndView searchTshirts() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("searchTshirt");
		return mv;
	}
	
	@RequestMapping("/filterTshirts")
	public ModelAndView getTshirts(HttpServletRequest req,HttpServletResponse res) {
		ArrayList<MyTshirt> result=this.tdao.getRequiredTshirts(req.getParameter("colour"),req.getParameter("size"),req.getParameter("gender"), req.getParameter("pref"));
		ModelAndView mv=new ModelAndView();
		mv.addObject("reqTshirts", result);
		mv.setViewName("searchPage");
		return mv;
	}

}
