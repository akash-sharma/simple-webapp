package com.akash.servlet.ws.jersey;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @XmlRootElement depicts that User object can be converted to xml
 *
 */

@XmlRootElement(name = "user")
public class User {

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
