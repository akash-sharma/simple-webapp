package com.akash.servlet.ws;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

@WebServlet(value = "/simplews")
public class SimpleWebService extends HttpServlet {

	private static final long serialVersionUID = 100L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		String format = req.getParameter("format");
		String payload = null;
		if (format != null && format.equalsIgnoreCase("JSON")) {
			payload = generateJsonResponse();
		} else {
			payload = generateXmlResponse();
		}
		if (payload == null) {
			payload = "something went wrong...";
		}
		OutputStream out = res.getOutputStream();
		out.write(payload.getBytes());
		out.flush();
	}

	private String generateJsonResponse() {

		try {
			JSONObject jobt = XML.toJSONObject(generateXmlResponse());
			return jobt.toString(3);
		} catch (Exception e) {
			System.out.println("exception occured while parsing json:" + e);
		}
		return null;
	}

	private String generateXmlResponse() {
		User user = createUser();
		String xml = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder encoder = new XMLEncoder(out);
		encoder.writeObject(user); // serialize to XML
		encoder.close();
		xml = out.toString();
		return xml;
	}

	private User createUser() {
		User user = new User();
		user.setCity("new york");
		user.setName("ashok");
		return user;
	}
}