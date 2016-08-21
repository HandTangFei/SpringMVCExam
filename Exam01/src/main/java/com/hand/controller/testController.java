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
@RequestMapping("/test")
public class testController {
	
	private CustomerService customerService = new CustomerService() ;
	private static Logger log=LoggerFactory.getLogger(testController.class);
	
	@ RequestMapping(value="/allCustomers")
	public ModelAndView showCustomers(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String currentPage = Integer.toString(request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage")));
		

		System.out.println("Here1");
		
		// 接受页面的值
//		String command = req.getParameter("command");
//		String description = req.getParameter("description");
//		String currentPage = req.getParameter("currentPage");
		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		
		
		List<Customer> customers = customerService.getCustomers(page);
		for(Customer cus:customers){
			System.out.println(cus.getFirst_name());
		}
		// 查询消息列表并传给页面
		mv.addObject("customers",customers);
		// 向页面传值

		mv.addObject("page",page);
//		mv.addObject("command", command);
//		mv.addObject("description", description);
		
		mv.setViewName("list");
		log.warn("Done");
		return mv;
	}
}
