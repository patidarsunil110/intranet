package com.idbiintech.intranet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	IUserService userService;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home");

	}

	@GetMapping("/signup")
	public ModelAndView signup() {
		return new ModelAndView("index");

	}

	@PostMapping("/signup")
	public ModelAndView signup(@ModelAttribute("welcome") UserDTO userDTO, Model model) {
		int empList = userService.saveEmployee(userDTO);
		if (empList > 0) {
			model.addAttribute("msg", "User Added!!!!!!!!!!");
			return new ModelAndView("index");
		} else {
			model.addAttribute("errorMsg", "User Not Added Please enter correct details!!!");
			return new ModelAndView("index");

		}
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("auth") UserDTO userDTO, HttpSession session, HttpServletRequest request,
			Model model) {
		UserDTO isValided = userService.loginUser(userDTO);
		try {
			if (isValided != null) {
				session = request.getSession();
				session.setAttribute("username", isValided.getEmpFirstName() + " " + isValided.getEmpLastName());
				model.addAttribute("msg", "Welcome....You Are Logged Successfully");
				logger.info("Accessing List of all Employees :--- Stating ------>> ");
				List<UserDTO> allEmployees = userService.getAllEmployees();
				model.addAttribute("employees", allEmployees);
				return new ModelAndView("welcome");
			} else {
				model.addAttribute("errorMsg", "Please enter valid email or password!");
				return new ModelAndView("home");
			}
		} catch (Exception e) {
			System.out.println("Controller issue !!!!!!!!!!!!!!!!" + e);
			return new ModelAndView("home");
		}
	}
}