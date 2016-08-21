package com.hand.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.inter.AddressInter;
import com.hand.model.Address;



public class AddressService {

   	private static ApplicationContext ctx;
	static
	{
		ctx = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
	}
	
	public Address getAddressById(int id){
		Address address = null;
		try {
    		AddressInter addressMapper =  (AddressInter) ctx.getBean("addressMapper");
    		address = addressMapper.getAddressById(id);
			if(address == null){
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	public List<Address> getAllAddress() {
		List<Address> address = new ArrayList<Address>();
		try {
    		AddressInter addressMapper =  (AddressInter) ctx.getBean("addressMapper");
    		address = addressMapper.getAllAddress();
			if(address == null){
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return address;
		
	}

}
