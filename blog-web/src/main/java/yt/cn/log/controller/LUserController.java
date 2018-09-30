package yt.cn.log.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("luser")
public class LUserController {
	
	@GetMapping("personal")
	public String personal(Model model){
		return "personal";
	}
}
