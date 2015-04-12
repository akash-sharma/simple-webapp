package com.akash.servlet.ws.soap.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class CalculatorSoapHandler implements SOAPHandler<SOAPMessageContext> {

	// http://java.dzone.com/articles/creating-soap-message-handlers
	// http://www.coderanch.com/t/540427/Web-Services/java/print-JAXWS-request-response

	public CalculatorSoapHandler() {
	}

	public void close(MessageContext mCtx) {
	}

	public Set<QName> getHeaders() {
		return null;
	}

	public boolean handleFault(SOAPMessageContext mCtx) {
		printMessage(mCtx);
		return true;
	}

	public boolean handleMessage(SOAPMessageContext mCtx) {
		printMessage(mCtx);
		return true; // continue down the handler chain
	}

	private void printMessage(SOAPMessageContext mCtx) {
		Boolean outbound = (Boolean) mCtx
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		// When Server sending Response
		if (outbound) {
			try {
				System.out
						.println("-----------Server Response Envolope starts-----------");
				mCtx.getMessage().writeTo(System.out);
				System.out
						.println("-----------Server Response Envolope Ends-----------");
			} catch (Exception e) {
				throw new RuntimeException("SOAPException thrown.", e);
			}
		} else { // When Server getting Request
			try {
				System.out
						.println("-----------Server Request Envolope starts-----------");
				mCtx.getMessage().writeTo(System.out);
				System.out
						.println("-----------Server Request Envolope ends-----------");
			} catch (Exception e) {
				throw new RuntimeException("SOAPException thrown.", e);
			}
		}
	}

}