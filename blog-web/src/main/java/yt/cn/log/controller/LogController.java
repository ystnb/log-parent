package yt.cn.log.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log")
public class LogController {

	@GetMapping("weAre")
	public String weAre(Model model){
		return "/log";
	}
	@GetMapping("advice")
	public String advice(Model model){
		return "/advice";
	}
}
