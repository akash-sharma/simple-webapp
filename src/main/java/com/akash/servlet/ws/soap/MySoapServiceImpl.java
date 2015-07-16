package com.akash.servlet.ws.soap;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MySoapServiceImpl {

	private static final int maxRands = 16;

	@WebMethod
	public int next1() {
		return new Random().nextInt();
	}

	@WebMethod
	public int[] nextN(final int n) {
		final int k = (n > maxRands) ? maxRands : Math.abs(n);
		int[] rands = new int[k];
		Random r = new Random();
		for (int i = 0; i < k; i++)
			rands[i] = r.nextInt();
		return rands;
	}
}

/**
 * localhost/jaxws/mysoap?xsd=1
 * localhost/jaxws/mysoap?wsdl
 * 
 * (1)Run 
 * mvn clean install
 * 
 * (2)Run following command from 
 * simple-webapp\target\classes folder
 * 
 * wsgen -verbose -keep -cp . com.akash.servlet.ws.soap.MySoapServiceImpl
 * 
 * (3)Copy java files from javax package to src/main/java folder
 * 
 * Step (2) and (3) are implemented itself by using endpoint publisher.
 */
