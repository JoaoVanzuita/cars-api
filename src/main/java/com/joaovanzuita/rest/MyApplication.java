package com.joaovanzuita.rest;

import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyApplication extends Application {

	@Override
	public Map<String, Object> getProperties() {
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages", "com.joaovanzuita.rest");
		
		return properties;
	}	
}
