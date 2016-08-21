package com.hand.controller;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hand.model.Customer;
import com.hand.service.CustomerService;
import com.hand.utils.entity.Page;

@Controller
@RequestMapping()
public class LoginController {
	
	private CustomerService customerService = new CustomerService() ;
	private static Logger log=LoggerFactory.getLogger(LoginController.class);
	
	@ RequestMapping("/login")
	public ModelAndView showCustomers(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		log.warn("Done");
		return mv;
	}
	
	
	@ RequestMapping("/dologin")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
			
		// 接受页面的值
		
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		System.out.println(password);
		System.out.println(userName);
		
		if(password ==null || customerService.getCustomerByFirstName(userName) == null){
			mv.setViewName("login");
			log.warn("Login failed!");
			return mv;
		}else{
			
			String currentPage = Integer.toString(request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage")));
	
			System.out.println("Here1");

			// 创建分页对象
			Page page = new Page();
			Pattern pattern = Pattern.compile("[0-9]{1,9}");
			if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
				page.setCurrentPage(1);
			} else {
				page.setCurrentPage(Integer.valueOf(currentPage));
			}
			List<Customer> customers = customerService.getCustomers(page);

			// 查询消息列表并传给页面
			mv.addObject("customers",customers);
			mv.addObject("page",page);
			mv.setViewName("index");
			log.warn("Login success!");
			return mv;
			
		}
		
	}
	
}
