package com.hand.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hand.model.Customer;


public interface CustomerInter {
	public void addCustomer(Customer customer);

	public Customer getCustomer();

	public List<Customer> getCustomers();
	
	public List<Customer> getCustomersByPage(@Param("offset")int offset,@Param("pagesize")int pagesize);
	
	public int count();
	
	public List<Customer> queryMessageListByPage(Map<String,Object> parameter);
	
	
	
	
	//Exam中用到的
	public Customer getCustomerByFirstName(String firstName);

	public Customer getCustomerByCustomer_Id(Integer customer_id);

	public void modifyCustomer(Customer customer);
}
