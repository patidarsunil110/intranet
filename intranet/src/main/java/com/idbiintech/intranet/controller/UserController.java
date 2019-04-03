package com.idbiintech.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.idbiintech.intranet.dto.UserDTO;
import com.idbiintech.intranet.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("login");

	}

	@PostMapping("/login")
	public ModelAndView index(@ModelAttribute("welcome") UserDTO userDTO) {
		int empList = userService.authentication(userDTO);
		System.out.println(empList);
		return new ModelAndView("home"); 
	}

}
