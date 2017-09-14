package org.jdcomp.app.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jdcomp.app.models.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	MemberDao mdo;
	
	@GetMapping("/login")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("t_login");
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView postLoginHandler(@RequestParam Map map, HttpSession session) {
		ModelAndView mav = new ModelAndView("t_login");
		int r = mdo.checklogin(map);
		if(r==1) {
			Map info = mdo.getInfo(map);
			session.setAttribute("auth", info);
			return mav;
		}else {
			mav.addObject("temp", "on");
			return mav;
		}
	}
}
