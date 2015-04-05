package com.akash.servlet.ws.jersey;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/userLatest")
public class JerseyResouceLatest {

	@POST
	@Produces({ MediaType.APPLICATION_XML })
	public Response getXml() {
		return Response.ok(createUser(), MediaType.APPLICATION_XML).build();
	}

	//TODO apply @PathParam
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/json")
	public Response getJson() {
		return Response.ok(toJson(createUser()), MediaType.APPLICATION_JSON).build();
	}

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

curl --header "Accept:application/json" --request POST  
--data "name=ashok&city=delhi" http://localhost/resourcesUser/userLatest/json
{"name":"ashok","city":"new york"}


curl --request POST http://localhost/resourcesUser/userLatest
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<user>
	<city>new york</city>
	<name>ashok</name>
</user>

*/