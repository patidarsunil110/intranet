package com.idbiintech.intranet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.idbiintech.intranet.dto.EmployeeDTO;
import com.idbiintech.intranet.service.IEmployeeService;


@Controller
public class EmployeeController {
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@Value("${server.servlet.context-path}")
	private String applicationContext;

	
	@Autowired
	public IEmployeeService userService;
	
	EmployeeDTO usersList;
	//First page of application.
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("Login");

	}
	//home page
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
	public ModelAndView signup(@ModelAttribute("welcome") EmployeeDTO userDTO, Model model) {
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
	public ModelAndView login(@ModelAttribute("auth") EmployeeDTO userDTO, HttpSession session, HttpServletRequest request,
			Model model) {
		try {
		usersList = userService.loginUser(userDTO);
		String role=usersList.getRoleName();
		
			if (usersList != null) {
				session = request.getSession();
				session.setAttribute("username", usersList.getEmpFirstName() + " " + usersList.getEmpLastName());
				/*model.addAttribute("msg", "Welcome....You Are Logged Successfully");*/
				 if(role.equalsIgnoreCase("Employees")){
					 //date 080619  model.addAttribute("empId",usersList.getEmpId()); 
					 session.setAttribute("totalHours",usersList.getTotalHours());
					 session.setAttribute("checkIn",usersList.getCheckIn());
					// model.addAttribute("homePages", usersList);
					return new ModelAndView("Home");
				}
				else if(role.equalsIgnoreCase("Manager")) {
				return new ModelAndView("managerHome");
				}else if(role.equalsIgnoreCase("Admin")) {
					return new ModelAndView("adminHome");
					}
				
			} else {
				model.addAttribute("errorMsg", "Please enter valid email or password!");
				return new ModelAndView("Login");
			}
		} catch (Exception e) {
			System.out.println("Controller issue !!!!!!!!!!!!!!!!" + e);
			return new ModelAndView("Login");
		}
		return new ModelAndView("Login");
	}
	
	/*@GetMapping("/attendance")
	public ModelAndView attendance(@ModelAttribute("attendance") EmployeeDTO userDTO, HttpSession session,
			HttpServletRequest request, Model model) {
		//UserDTO list = userService.getUserByAttendance(userDTO);
		EmployeeDTO list=userService.getUserByAttendance(usersList.getEmpId());
		session = request.getSession();
		try {
			if (list.getEmpId() == usersList.getEmpId()) {
				List<EmployeeDTO> attendanceList = userService.getUserByAttendanceEmpId(list.getEmpId());
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
	
	@GetMapping("/teamList")
	public ModelAndView teamList(Model model) {
		List<EmployeeDTO> teamList=userService.getTeamList(usersList.getEmpId(),usersList.getManagerId(),usersList.getTeamId());
		model.addAttribute("team",teamList);
		return new ModelAndView("Attendance");
	}
	*/
	@GetMapping("/search")
	public ModelAndView search(@ModelAttribute("searchParam") String searchParam, Model model) {
		logger.info("Accessing List By Serach Parameters:-- ");
		List<EmployeeDTO> list = userService.getUserById(searchParam);
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
			/* @RequestParam("empId") int empId, */@ModelAttribute("updateEmployee") EmployeeDTO userDTO, Model model) {
		List<EmployeeDTO> list = userService.getUserByIdForUpdate(userDTO.getEmpId());
		EmployeeDTO users = list.get(0);
		model.addAttribute("user", users);
		return new ModelAndView("updatedetails");
	}

	@PostMapping("/updateUser")
	public ModelAndView updateUser(@ModelAttribute("update") EmployeeDTO userDTO, Model model) {
		logger.info("update users");

		int list = userService.updateEmployee(userDTO);
		List<EmployeeDTO> allEmployees = userService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return new ModelAndView("welcome");
	}

	@GetMapping("/deleteUser")
	public ModelAndView deleteUser(@ModelAttribute("deleteUser") EmployeeDTO userDTO, Model model) {
		int delete = userService.deleteUser(userDTO.getEmpId());
		List<EmployeeDTO> allEmployees = userService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return new ModelAndView("welcome");

	}

	@GetMapping("/allUsers")
	public ModelAndView allusers(Model model) {

		logger.info("Accessing List of all Employees :--- Stating ------>> ");
		List<EmployeeDTO> allEmployees = userService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return new ModelAndView("welcome");
	}
}