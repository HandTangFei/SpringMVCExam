package com.hand.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.inter.CustomerInter;
import com.hand.model.Customer;
import com.hand.utils.entity.Page;


public class CustomerService {

   	private static ApplicationContext ctx;
	static
	{
		ctx = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
	}
	
	@SuppressWarnings("resource")
	public String[] inputInfo(){
		String[] strs = new String[4];
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入FirstName(first_name)：");
		String m=sc.next();
		strs[0] = m;

		sc=new Scanner(System.in);
		System.out.println("请输入LastName(last_name)：");
		m=sc.next();
		strs[1] = m;

		sc=new Scanner(System.in);
		System.out.println("请输入Email(email)：");
		m=sc.next();
		strs[2] = m;

		sc=new Scanner(System.in);
		System.out.println("请输入Address ID：");
		m=sc.next();
		int id = Integer.parseInt(m);
		while(new AddressService().getAddressById(id) == null){
			System.out.println("你输入的Address ID不存在，请重新输入：");
			m=sc.next();
			id = Integer.parseInt(m);
		}
		strs[3] = m;
		sc.close();
		return strs;

	}

	
	public boolean saveCustomer(Customer customer){
		boolean bool = false;
		try {
			customer.setStore_id(1);
			customer.setActive(1);
			Date now = new Date(); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			customer.setCreate_date(format.format(now));
			customer.setLast_update(format.format(now));
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customerMapper.addCustomer(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	
	
	public boolean saveCustomer(String[] strs){
		boolean bool = false;
		Customer customer = new Customer();
		try {
			customer.setStore_id(1);
			customer.setActive(1);
			customer.setFirst_name(strs[0]);
			customer.setLast_name(strs[1]);
			customer.setEmail(strs[2]);
			customer.setAddress_id(Integer.parseInt(strs[3]));
			Date now = new Date(); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			customer.setCreate_date(format.format(now));
			customer.setLast_update(format.format(now));
			
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customerMapper.addCustomer(customer);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public Customer getCustomer(){
		Customer customer = new Customer();
		try {
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customer = customerMapper.getCustomer();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return customer;
	}

	
	public Customer getCustomerByFirstName(String firstName){
		Customer customer = new Customer();
		try {
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customer = customerMapper.getCustomerByFirstName(firstName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return customer;
	}
	
	
	public Customer getCustomerByCustomer_Id(Integer customer_id ){
		Customer customer = new Customer();
		try {
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customer = customerMapper.getCustomerByCustomer_Id(customer_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return customer;
	}
	

	public boolean modifyCustomer(Customer customer) {
		boolean bool = true;
		try {
			Date now = new Date(); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			customer.setLast_update(format.format(now));
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customerMapper.modifyCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return bool;
	}
	
	
	
	
	public List<Customer> getCustomers(Page page) {
		List<Customer> customers;
		try {
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		
    		
    		Map<String,Object> parameter = new HashMap<String, Object>();
    		// 组织消息对象
    		parameter.put("message", "message");
    		parameter.put("page", page);
    		
    		int totalNumber = customerMapper.count();
    		// 组织分页查询参数
    		page.setTotalNumber(totalNumber);
    		System.out.println(totalNumber);
//    		Map<String,Object> parameter = new HashMap<String, Object>();
    		// 分页查询
    		customers = customerMapper.queryMessageListByPage(parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return customers;
	}



	
	
}
