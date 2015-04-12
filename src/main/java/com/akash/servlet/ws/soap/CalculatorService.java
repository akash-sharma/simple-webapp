package com.akash.servlet.ws.soap;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@HandlerChain(file="handler/handler-chain.xml")
public class CalculatorService {

	@WebMethod
	public int add(int a, int b) {
		return a + b;
	}

	@WebMethod
	public int subtract(int a, int b) {
		return a - b;
	}

	@WebMethod
	public int multiply(int a, int b) {
		return a * b;
	}

	@WebMethod
	public int divide(int a, int b) throws InvalidDenominatorException {
		if (b != 0) {
			return a / b;
		} else {
			throw new InvalidDenominatorException("denominator cannot be 0",
					"denominator cannot be 0");
		}
	}
}
