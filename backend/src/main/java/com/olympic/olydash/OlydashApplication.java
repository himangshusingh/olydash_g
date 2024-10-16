package com.olympic.olydash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@OpenAPIDefinition
public class OlydashApplication {
	private static final Logger log = LoggerFactory.getLogger(OlydashApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OlydashApplication.class);

		Environment env = app.run(args).getEnvironment();
		logApplicationStartup(env);
	}

	private static void logApplicationStartup(Environment env) {

		String serverPort = env.getProperty("server.port");
//		String contextPath = env.getProperty("server.servlet.context-path");
		String contextPath = "/";
		String protocol = "http";
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("""
                        
                        ----------------------------------------------------------
                        \t\
                        Application is running! Access URLs:
                        \t\
                        Local: \t\t{}://localhost:{}{}
                        \t\
                        External: \t{}://{}:{}{}
                        \t\
                        
                        -----------------------------------------------------------""",
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath);
	}
}



// to initialize UI, currently keeping Angular localhost:4200 in mind
@Configuration
class MyWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200")
        .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
        // .allowedHeaders("Content-Type", "Authorization", "API-KEY")
        // .exposedHeaders("API-KEY")
        .allowCredentials(true);
	}
}
