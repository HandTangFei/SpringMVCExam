package com.hand.inter;

import java.util.List;

import com.hand.model.Address;


public interface AddressInter {
	public Address getAddressById(int id);

	public List<Address> getAllAddress();

	public Address getAddressByName(String address);
}
