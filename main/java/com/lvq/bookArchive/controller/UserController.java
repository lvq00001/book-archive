	package com.lvq.bookArchive.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lvq.bookArchive.domain.BookUser;
import com.lvq.bookArchive.service.BookUserService;

@Controller
public class UserController {
	
	@Autowired
	private BookUserService bookUserService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}


	@RequestMapping(value="/wrong-password-username", method=RequestMethod.GET)
	public String wrongPasswordOrUserName() {
		return "wrong-password-username";
	}

	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public String accessDenied() {
		return "access-denied";
	}

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegister(Model model) {
		BookUser bu = new BookUser();
		model.addAttribute("bu", bu);
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(Model model,@ModelAttribute("bu") @Valid BookUser bu, BindingResult bindingResult) {
		
		if (bookUserService.getUserByUsername(bu.getUsername()) != null) {
			String rs = "USER ALREADY EXISTS, CHOOSE DIFFERENT USER NAME!";
			model.addAttribute("rs", rs);
			return "register";
		}
		
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(bu.getUser_password());
		bu.setUser_password(encodedPassword);
		bookUserService.saveUser(bu);
		String register = "User is added successfully, please login.";
		model.addAttribute("register", register);
		return "login";
	}

	@RequestMapping(value="/logout")
	public String logout() {
		return "redirect:/bookArchive/logout";
	}
	
	@RequestMapping(value="/user-info")
	public String userInfo(Model model, HttpServletRequest request) {
		String username = request.getUserPrincipal().getName();
		model.addAttribute("username", username);
		return "userInfo";
	}
	
}
