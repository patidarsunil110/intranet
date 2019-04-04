package com.idbiintech.intranet.controller;

import java.util.List;

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

	@PostMapping("/signup")
	public ModelAndView index(@ModelAttribute("welcome") UserDTO userDTO) {
		int empList = userService.authentication(userDTO);
		System.out.println(empList);
		return new ModelAndView("home"); 
	}
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("auth") UserDTO userDTO) {
		List<UserDTO> checkList=userService.loginUser(userDTO);
		return new ModelAndView("home");
	}

}
