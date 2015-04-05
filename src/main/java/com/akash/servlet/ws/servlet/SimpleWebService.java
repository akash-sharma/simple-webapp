package com.akash.servlet.ws.servlet;

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

	/**
	 * xml response : http://localhost/simplews
	 * 
	 * json response : http://localhost/simplews?format=json
	 */
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


/**
 * xml response 
 *
	<java version="1.7.0_40" class="java.beans.XMLDecoder">
		<object class="com.akash.servlet.ws.servlet.User">
			<void property="city">
				<string>new york</string>
			</void>
			<void property="name">
				<string>ashok</string>
			</void>
		</object>
	</java>
 *
 */

/**
 *JSON response
 *  
 {"java": {
   "class": "java.beans.XMLDecoder",
   "object": {
      "class": "com.akash.servlet.ws.servlet.User",
      "void": [
         {
            "property": "city",
            "string": "new york"
         },
         {
            "property": "name",
            "string": "ashok"
         }
      ]
   },
   "version": "1.7.0_40"
}}
 *
 */