package r2s.com.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.UserDetailsDTO;
import r2s.com.models.Department;
import r2s.com.models.Employee;
import r2s.com.models.useCase;
import r2s.com.service.DepartmentService;
import r2s.com.service.EmployeeService;

@Controller
public class HomeController {
	
	private final static Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/home")
	public String homePage(HttpSession session) {
		logger.info("postLogin()");
		// read principal out of security context and set it to session
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		useCase loggedInUser = ((UserDetailsDTO) authentication.getPrincipal()).getUser();
		session.setAttribute("useCase", loggedInUser);
		return "home";
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		logger.info("load into add page");
	    List<Department> listDepartments = departmentService.findAll();
	    ModelAndView mv = new ModelAndView("add");
	    mv.addObject("listDepartment",listDepartments);
	    return mv;
	}

	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		logger.info("load into list page");
	    List<Employee> listEmployees = employeeService.findAll();
	    ModelAndView mv = new ModelAndView("lists");
	    mv.addObject("listEmployee", listEmployees);
	    String status = request.getParameter("status");
	    request.setAttribute("status", status);
	    return mv;
	}
	
	@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee, HttpServletRequest request) {
		boolean flag;
		try {
			Optional<Department> department = departmentService.findById(newEmployee.getDepartment().getIdDepartment());
			Department d = department.get();
			newEmployee.setDepartment(d);
			employeeService.save(newEmployee);
			flag = true;
			logger.info("add employee success");
		} catch (Exception e) {
			flag = false;
			logger.info("add employee failed");
			logger.error(e);
		}
		if(flag)
			request.setAttribute("status", "success");
		else
			request.setAttribute("status", "failed");
		return "add";
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam("idEmployee") int idEmployee) {
		logger.info("load into edit page: " + idEmployee);
	    Optional<Employee> e = employeeService.findById(idEmployee);
	    Employee employees = e.get();
	    List<Department> listDepartments = departmentService.findAll();
	    ModelAndView mv = new ModelAndView("update");
	    mv.addObject("employee", employees);
	    mv.addObject("listDepartment", listDepartments);
	    //logger.info("");
	    return mv;
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("idEmployee") int idEmployee) {
		employeeService.deleteById(idEmployee);
		logger.info("delete employee success");
		return "redirect:/list";
	}
	
	@RequestMapping(value="/editEmployee",method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("newEmployee") Employee newEmployee, HttpServletRequest request) {
		
		boolean flag;
		try {
			Optional<Department> department = departmentService.findById(newEmployee.getDepartment().getIdDepartment());
			Department d = department.get();
			newEmployee.setDepartment(d);
			employeeService.save(newEmployee);
			flag = true;
			logger.info("update employee success");
		} catch (Exception e) {
			flag = false;
			logger.info("update employee failed");
			logger.error(e);
		}
		if(flag)
			request.setAttribute("status", "success");
		else
			request.setAttribute("status", "failed");
		return "redirect:/list?status=" + request.getAttribute("status");
	}
}
