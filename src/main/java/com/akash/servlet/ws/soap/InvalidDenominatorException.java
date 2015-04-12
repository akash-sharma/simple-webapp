package com.akash.servlet.ws.soap;

import javax.xml.ws.WebFault;

//	http://stackoverflow.com/questions/2064447/jax-ws-map-exceptions-to-faults

@WebFault
public class InvalidDenominatorException extends Exception {

	private static final long serialVersionUID = 100003L;

	private String details;

	public InvalidDenominatorException(String reason, String details) {
		super(reason);
		this.details = details;
	}

	public String getFaultInfo() {
		return this.details;
	}
}
