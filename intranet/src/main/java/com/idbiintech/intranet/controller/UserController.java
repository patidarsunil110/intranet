package com.idbiintech.intranet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");

	}

	@PostMapping("/signup")
	public ModelAndView index(@ModelAttribute("welcome") UserDTO userDTO) {
		int empList = userService.saveEmployee(userDTO);
		System.out.println(empList);
		return new ModelAndView("home");
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("auth") UserDTO userDTO, HttpSession httpSession,
			HttpServletRequest request, Model model) {
		boolean isValided = userService.loginUser(userDTO);
		try {
			if (isValided) {
				httpSession = request.getSession();
				httpSession.setAttribute("username", userDTO.getEmpName() + " " + userDTO.getEmpLastName());
				return new ModelAndView("welcome");
			} else {
				model.addAttribute("msg", "Please enter valid email or password!");
				return new ModelAndView("home");
			}
		} catch (Exception e) {
			System.out.println("Controller issue !!!!!!!!!!!!!!!!" + e);
			return new ModelAndView("home");
		}
	}
}