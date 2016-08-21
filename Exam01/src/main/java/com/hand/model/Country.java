package com.hand.model;

import java.sql.Date;

public class Country {
	private int country_id;
	private String country;
	private Date last_update;
	/**
	 * @return the country_id
	 */
	public int getCountry_id() {
		return country_id;
	}
	/**
	 * @param country_id the country_id to set
	 */
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
