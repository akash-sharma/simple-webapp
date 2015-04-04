package com.akash.servlet.ws;

import java.io.Serializable;

/**
 * NOTE: XMLEncoder requires the Serializable class to be as public
 * @author Admin
 *
 */

public class User implements Serializable {

	private static final long serialVersionUID = 101L;

	private String name;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}