package com.akash.servlet.ws.jersey;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * A servlet i.e. (com.sun.jersey.spi.container.servlet.ServletContainer) is
 * registered for scanning annotations.
 */

@ApplicationPath("/resourcesUser")
public class JerseyService extends Application {

	@Override
	public Set<java.lang.Class<?>> getClasses() {

		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JerseyResource.class);
		set.add(JerseyResouceLatest.class);
		return set;
	}
}