package com.ajt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajt.model.Employee;
import com.ajt.service.IEmployeeService;
import com.ajt.util.CaptchaUtil;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	private String captchaAns;

	private void setupCatpcha(Employee employee) {
		try {
			Captcha captcha = CaptchaUtil.createCaptcha(200, 40);
			employee.setCaptchaData(CaptchaUtil.encodeCaptchaImageBase64(captcha, "png"));
			captchaAns = captcha.getAnswer();
			employee.setUserAnswer("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/register")
	public String showRegister(Model model) {
		return "redirect:all";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee) {
		if(captchaAns.equals(employee.getUserAnswer())) {
			service.createEmployee(employee);
		}
		return "redirect:all";
	}

	@GetMapping("/all")
	public String getAllEmployee(Model model) {
		Employee employee = new Employee();
		setupCatpcha(employee);
		model.addAttribute("employee", employee);
		model.addAttribute("list", service.getAllEmployees());
		return "employeeRegister";
	}

	@GetMapping("/delete")
	public String save(@RequestParam Integer id) {
		service.deleteEmployee(id);
		return "redirect:all";
	}

}
