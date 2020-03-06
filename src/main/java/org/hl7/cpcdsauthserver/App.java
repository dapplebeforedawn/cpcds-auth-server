package org.hl7.cpcdsauthserver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	private static String secret = "secret";
	private static final String ehrServer = "http://localhost:8080/cpcds-server/fhir";

	public static void main(String[] args) {
		// Set the secret
		if (System.getenv("jwt.secret") != null)
			App.secret = System.getenv("jwt.secret");

		SpringApplication.run(App.class, args);
	}

	public static String getSecret() {
		return App.secret;
	}

	public static String getEhrServer() {
		return App.ehrServer;
	}

	/**
	 * Get the base url of the service from the HttpServletRequest
	 * 
	 * @param request - the HttpServletRequest from the controller
	 * @return the base url for the service
	 */
	public static String getServiceBaseUrl(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
	}

}
