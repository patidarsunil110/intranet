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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.idbiintech.intranet.dto.EmployeeDTO;
import com.idbiintech.intranet.service.IAttendanceService;

/*import com.idbiintech.intranet.dto.userList;*/
@Controller
public class AttendanceController {

	@Value("${server.servlet.context-path}")
	private String applicationContext;

	private static final Logger logger = LogManager.getLogger(AttendanceController.class);
	@Autowired
	public IAttendanceService attendanceService;

	EmployeeDTO usersList;

	@PostMapping("/attendance")
	public ModelAndView attendance(@ModelAttribute("attendance") EmployeeDTO userDTO, @RequestParam("empId") int empId,
			HttpSession session, HttpServletRequest request, Model model) {

		// UserDTO list = attendanceService.getUserByAttendance(userDTO);
		// EmployeeDTO list=attendanceService.getUserByAttendance(empId);
		session = request.getSession();
		try {
			// if (list.getEmpId() == usersList.getEmpId()) {
			List<EmployeeDTO> attendanceList = attendanceService.getUserByAttendanceEmpId(empId);
			model.addAttribute("attendance", attendanceList);
			return new ModelAndView("Attendance");

		} catch (Exception e) {
			// TODO: handle exception

			logger.error("Attendance issue " + e);
			return new ModelAndView("Home");
		}

	}

	@GetMapping("/teamList")
	public ModelAndView teamList(Model model) {
		List<EmployeeDTO> teamList = attendanceService.getTeamList(usersList.getEmpId(), usersList.getManagerId(),
				usersList.getTeamId());
		model.addAttribute("team", teamList);
		return new ModelAndView("Attendance");
	}

}
