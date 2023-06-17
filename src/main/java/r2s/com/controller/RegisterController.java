package r2s.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.models.useCase;
import r2s.com.service.UseCaseService;

@Controller
public class RegisterController {
	
	private final static Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private UseCaseService usecaseService;
	
	@RequestMapping("/register")
	public String register() {
		logger.info("load into register");
		return "register";
	}
	
	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	public String addNewUseCase(@ModelAttribute("newUseCase") useCase newUseCase, HttpServletRequest request,HttpSession session, Model model) {
	    List<useCase> existingUseCasesByEmail = usecaseService.findUseCaseByEmail(newUseCase.getEmail());
	    List<useCase> existingUseCasesByUserName = usecaseService.findUseCaseByUserName(newUseCase.getUserName());
	    if (!existingUseCasesByEmail.isEmpty()) {
	        request.setAttribute("status", "failedEmail");
	        logger.warn("register failed because of duplicated email");
	        model.addAttribute("useCase", newUseCase);
	    } else if (!existingUseCasesByUserName.isEmpty()) {
	    	model.addAttribute("useCase", newUseCase);
	        request.setAttribute("status", "failedUserName");
	        logger.warn("register failed because of duplicated username");
	    } else {
	        try {
	        	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	        	String encryptedPwd = bcrypt.encode(newUseCase.getPassWord());
	        	newUseCase.setPassWord(encryptedPwd);
	            usecaseService.save(newUseCase);
	            request.setAttribute("status", "success");
	            logger.info("register success");
	            return "redirect:/login?status=success";
	        } catch (Exception e) {
	        	model.addAttribute("useCase", newUseCase);
	            request.setAttribute("status", "failed");
	            logger.info("register failed");
	            logger.error(e);
	        }
	    }
	    return "register";
	}
}
