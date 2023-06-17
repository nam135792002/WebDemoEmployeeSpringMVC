package r2s.com.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.service.UseCaseService;

@Controller
public class LoginController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UseCaseService usecaseService;

	
	@RequestMapping(value={"/login","/"})
	public ModelAndView login(@RequestParam(value = "error",required = false) String error, HttpServletRequest request) {
		logger.info("load into login page");
		ModelAndView model = new ModelAndView("/login");
		if (error != null) {
			logger.info("login failed");
			request.setAttribute("status", "failed");
		}
		return model;
	}
	
	@RequestMapping(value="/loginUseCase",method = RequestMethod.POST)
	public void loginUseCase() {
		
	}
	
//	@RequestMapping("/logout")
//	public String logoutUseCase(HttpSession session) {
//		session.invalidate();
//		logger.info("logout success");
//		return "login";
//	}
	
}
