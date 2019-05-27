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
import org.springframework.web.servlet.ModelAndView;

import com.idbiintech.intranet.dto.EmployeeDTO;
import com.idbiintech.intranet.service.IAttendanceService;
import com.idbiintech.intranet.service.IEmployeeService;

@Controller
public class AttendanceController {

	
	private static final Logger logger = LogManager.getLogger(AttendanceController.class);
	@Autowired
	IEmployeeService  attendanceService;
	
	EmployeeDTO usersList;
	@GetMapping("/attendance")
	public ModelAndView attendance(@ModelAttribute("attendance") EmployeeDTO userDTO, HttpSession session,
			HttpServletRequest request, Model model) {
		//UserDTO list = attendanceService.getUserByAttendance(userDTO);
		EmployeeDTO list=attendanceService.getUserByAttendance(usersList.getEmpId());
		session = request.getSession();
		try {
			if (list.getEmpId() == usersList.getEmpId()) {
				List<EmployeeDTO> attendanceList = attendanceService.getUserByAttendanceEmpId(list.getEmpId());
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
		List<EmployeeDTO> teamList=attendanceService.getTeamList(usersList.getEmpId(),usersList.getManagerId(),usersList.getTeamId());
		model.addAttribute("team",teamList);
		return new ModelAndView("Attendance");
	}
	
}
