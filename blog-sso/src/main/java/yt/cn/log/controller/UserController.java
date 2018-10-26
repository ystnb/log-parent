package yt.cn.log.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yt.cn.log.pojo.lUser;
import yt.cn.log.service.lUserService;

@Controller
public class UserController {
	@Autowired
	private lUserService userService;
	@ResponseBody
	@GetMapping("cs")
	public String cs(){
		return "sso服务启动成功！";
	}
	
	@GetMapping("/")
	public String login(String redirect,Model model){
		model.addAttribute("redirect", redirect);
		return "/login";
	}
	@GetMapping("register")
	public String register(){
		return "/register";
	}
	@PostMapping("addUser")
	public String addUser(@ModelAttribute lUser user,HttpServletRequest request){
		String code =request.getParameter("code");
		
		try {
			userService.insertBody(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "/register";
		}
		return "redirect:/";
		
	}
}
