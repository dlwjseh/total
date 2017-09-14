package org.jdcomp.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.jdcomp.app.models.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	@Autowired
	MemberDao mdo;

	@GetMapping("/join")
	public ModelAndView joinHandler() {
		ModelAndView mav = new ModelAndView("t_join");
		return mav;
	}
	@PostMapping("/join")
	public ModelAndView postJoinHandler(@RequestParam Map map) {
		System.out.println(map);
		ModelAndView mav = new ModelAndView("redirect:/");
		try {
			boolean b = mdo.Join(map);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("temp", map);
			mav.setViewName("/join");
			return mav;
		}
	}
	
	@RequestMapping("/signup_check/{mode}")
	@ResponseBody
	public String postJoinHandler(@PathVariable String mode, @RequestBody String idmail) {
		Map m = new HashMap();
		m.put("idmail", idmail);
		if(mode.equals("id")) {
			int r = mdo.checkId(m);
			if(r==0)
				return "YYYY";
			else
				return "NNNN";
		}else if(mode.equals("email")){
			int r = mdo.checkEmail(m);
			if(r==0)
				return "YYYY";
			else
				return "NNNN";
		}
		return "NNNN";
	}
}
