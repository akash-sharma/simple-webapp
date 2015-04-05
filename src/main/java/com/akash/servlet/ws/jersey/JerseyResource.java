package com.akash.servlet.ws.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/user")
public class JerseyResource {

	/**
	 * could use "application/xml"
	 * http://localhost/resourcesUser/user
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public JAXBElement<User> getXml() {
		return toXml(createUser());
	}

	/**
	 * http://localhost/resourcesUser/user/json
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/json")
	public String getJson() {
		return toJson(createUser());
	}

	private JAXBElement<User> toXml(User userObj) {
		return new JAXBElement<User>(new QName("User"), User.class, userObj);
	}

	/**
	 * ObjectMapper class serializes user object into json
	 * @param user
	 * @return
	 */
	private String toJson(User user) {
		String json = "If you see this, there's a problem.";
		try {
			json = new ObjectMapper().writeValueAsString(user);
		} catch (Exception e) {
		}
		return json;
	}

	private User createUser() {
		User user = new User();
		user.setCity("new york");
		user.setName("ashok");
		return user;
	}
}


/**
http://localhost/resourcesUser/user

<com.akash.servlet.ws.jersey.User>
<city>new york</city>
<name>ashok</name>
</com.akash.servlet.ws.jersey.User>


http://localhost/resourcesUser/user/json

{"name":"ashok","city":"new york"}

*/