package com.hand.model;

import java.sql.Date;

public class Store {
	private int store_id;
	private int manager_staff_id;
	private int address_id;
	private Date last_update;
	/**
	 * @return the store_id
	 */
	public int getStore_id() {
		return store_id;
	}
	/**
	 * @param store_id the store_id to set
	 */
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	/**
	 * @return the manager_staff_id
	 */
	public int getManager_staff_id() {
		return manager_staff_id;
	}
	/**
	 * @param manager_staff_id the manager_staff_id to set
	 */
	public void setManager_staff_id(int manager_staff_id) {
		this.manager_staff_id = manager_staff_id;
	}
	/**
	 * @return the address_id
	 */
	public int getAddress_id() {
		return address_id;
	}
	/**
	 * @param address_id the address_id to set
	 */
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	/**
	 * @return the last_update
	 */
	public Date getLast_update() {
		return last_update;
	}
	/**
	 * @param last_update the last_update to set
	 */
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
}
