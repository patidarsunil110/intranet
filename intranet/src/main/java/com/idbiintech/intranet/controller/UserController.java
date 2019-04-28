package com.idbiintech.intranet.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.idbiintech.intranet.dto.UserDTO;
import com.idbiintech.intranet.service.IUserService;

@Controller
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	IUserService userService;

	UserDTO isValided = null;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("Login");

	}

	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("Home");

	}

	@GetMapping("/leavebal")
	public ModelAndView leavebalance() {
		return new ModelAndView("Myleave");

	}

	@GetMapping("/leaveapply")
	public ModelAndView leaveapply() {
		return new ModelAndView("ApplyLeave");

	}

	@GetMapping("/attendance")
	public ModelAndView attendance(@ModelAttribute("attendance") UserDTO userDTO, HttpSession session,
			HttpServletRequest request, Model model) {

		UserDTO list = userService.getUserByAttendance(userDTO);     //
		session = request.getSession();
		try {
			if (list.getEmpId() == isValided.getEmpId()) {
				List<UserDTO> attendanceList = userService.getUserByAttendance();
				model.addAttribute("attendance", attendanceList);
				return new ModelAndView("Attendance"); 
			}else {
				return new ModelAndView("Home");
			}

		} catch (Exception e) {
			// TODO: handle exception

			logger.error("Attendance issue " + e);
			return new ModelAndView("Home");
		}
		
	}

	@GetMapping("/payslips")
	public ModelAndView payslips() {
		return new ModelAndView("Payslip");

	}

	@GetMapping("/tax")
	public ModelAndView tax() {
		return new ModelAndView("Tax");

	}

	@GetMapping("/vehicle")
	public ModelAndView vehicle() {
		return new ModelAndView("Vehicle");

	}

	@GetMapping("/mobile")
	public ModelAndView mobile() {
		return new ModelAndView("Mobile");

	}

	@GetMapping("/addEmployee")
	public ModelAndView signup() {
		return new ModelAndView("index");

	}

	@PostMapping("/addEmployee")
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
		isValided = userService.loginUser(userDTO);
		try {
			if (isValided != null) {
				session = request.getSession();
				session.setAttribute("username", isValided.getEmpFirstName() + " " + isValided.getEmpLastName());
				model.addAttribute("msg", "Welcome....You Are Logged Successfully");
				/*
				 * logger.info("Accessing List of all Employees :--- Stating ------>> ");
				 * List<UserDTO> allEmployees = userService.getAllEmployees();
				 * model.addAttribute("employees", allEmployees); return new
				 * ModelAndView("welcome");
				 */
				return new ModelAndView("Home");
			} else {
				model.addAttribute("errorMsg", "Please enter valid email or password!");
				return new ModelAndView("Login");
			}
		} catch (Exception e) {
			System.out.println("Controller issue !!!!!!!!!!!!!!!!" + e);
			return new ModelAndView("Login");
		}
	}

	@GetMapping("/search")
	public ModelAndView search(@ModelAttribute("searchParam") String searchParam, Model model) {
		logger.info("Accessing List By Serach Parameters:-- ");
		List<UserDTO> list = userService.getUserById(searchParam);
		model.addAttribute("employees", list);
		return new ModelAndView("welcome");

	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		logger.info("Logout user");
		session.invalidate();
		return new ModelAndView("Login");
	}

	@GetMapping("/updateUser")
	public ModelAndView updateEmployee(
			/* @RequestParam("empId") int empId, */@ModelAttribute("updateEmployee") UserDTO userDTO, Model model) {
		List<UserDTO> list = userService.getUserByIdForUpdate(userDTO.getEmpId());
		UserDTO users = list.get(0);
		model.addAttribute("user", users);
		return new ModelAndView("updatedetails");
	}

	@PostMapping("/updateUser")
	public ModelAndView updateUser(@ModelAttribute("update") UserDTO userDTO, Model model) {
		logger.info("update users");

		int list = userService.updateEmployee(userDTO);
		List<UserDTO> allEmployees = userService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return new ModelAndView("welcome");
	}

	@GetMapping("/deleteUser")
	public ModelAndView deleteUser(@ModelAttribute("deleteUser") UserDTO userDTO, Model model) {
		int delete = userService.deleteUser(userDTO.getEmpId());
		List<UserDTO> allEmployees = userService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return new ModelAndView("welcome");

	}

	@GetMapping("/allUsers")
	public ModelAndView allusers(Model model) {

		logger.info("Accessing List of all Employees :--- Stating ------>> ");
		List<UserDTO> allEmployees = userService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return new ModelAndView("welcome");
	}
}