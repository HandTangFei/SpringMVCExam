package com.hand.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;
import com.hand.model.Address;
import com.hand.model.Customer;
import com.hand.service.AddressService;
import com.hand.service.CustomerService;
import com.hand.utils.entity.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService = new CustomerService() ;
	private AddressService addressService = new AddressService();
	private static Logger log=LoggerFactory.getLogger(CustomerController.class);
	
	@ RequestMapping(value="/allCustomers")
	public ModelAndView showCustomers(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		// 接受页面的值
		String currentPage = Integer.toString(request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage")));
		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		List<Customer> customers = customerService.getCustomers(page);
		Address address =  new Address();
		List<String> adds = new ArrayList<String>();
		for(Customer cus:customers){
			address = addressService.getAddressById(cus.getAddress_id());
			if(address != null){
				if(address.getAddress()!=null){
					adds.add(address.getAddress());
				}else{
					adds.add(address.getAddress2());
				}
			}
		}
		List<Address> addressObjects = addressService.getAllAddress();
		// 查询消息列表并传给页面,向页面传值
		mv.addObject("customers",customers);
		mv.addObject("page",page);
		mv.addObject("adds", adds);
		mv.addObject("addressObjects", addressObjects);
		
		
		mv.setViewName("index");
		log.warn("Done");
		return mv;
	}
	
	
	@ RequestMapping(value="/addCustomer")
	public ModelAndView addCustomer(@ModelAttribute Customer customer,String address,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
//		String address = (String) request.getAttribute("address");
		System.out.println(address);
		System.out.println("add");
		Address addressObj = addressService.getAddressByName(address);
		List<Address> addressObjects = addressService.getAllAddress();
		customer.setAddress_id(addressObj.getAddress_id());
		
		mv.addObject("addressObjects", addressObjects);
		boolean bool = customerService.saveCustomer(customer);
		if(bool){
			System.out.println("Add successful!");
			mv.addObject("msg", "Add successful");
		}else{
			System.out.println("Add Failedl!");
			mv.addObject("msg", "Add Failedl!");
		}
		mv.setViewName("addCustomer");
		log.warn("Done");
		return mv;
	}
	
	
	@ RequestMapping(value="/getCustomer")
	public void getCustomer(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		String customer_id =  (String) request.getParameter("customer_id");
		System.out.println(customer_id);
		List<Customer> recordList = new ArrayList<Customer>();
		Customer customer = customerService.getCustomerByCustomer_Id(Integer.parseInt(customer_id));
		response.setCharacterEncoding("utf-8");
		if(customer !=null){
			recordList.add(customer);
			response.getWriter().write("{\"success\":true, \"data\":" + JSONUtil.serialize(recordList) + "}");
			response.getWriter().flush();
		}else{
			response.getWriter().write("{\"success\":false }");
			response.getWriter().flush();
		}
	}
	
	@ RequestMapping(value="/modifyCustomer")
	public void modifyCustomer(@ModelAttribute Customer customer,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{

		String address = request.getParameter("address");
		Address addressObj = addressService.getAddressByName(address);
//		System.out.println(addressObj.getAddress());
//		System.out.println(addressObj.getAddress_id());
		customer.setAddress_id(addressObj.getAddress_id());
		boolean  bool = customerService.modifyCustomer(customer);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{\"success\":true }");
		response.getWriter().flush();
	}
	
	@ RequestMapping(value="/deleteCustomer")
	public void deleteCustomer(@ModelAttribute Customer customer,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{\"success\":true }");
		response.getWriter().flush();
	}
}
