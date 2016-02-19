package library;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class Application {

	static Logger log = Logger.getLogger(Application.class.getName());

	 public static void main(String[] args) {
	  log.debug("Application was started");
	  SpringApplication.run(Application.class, args);
	 }

	 @PostConstruct
	 public void init() {
	  log.debug("Application init");
	  SecurityUtils.runAs("system", "system", "ROLE_ADMIN");
	  SecurityContextHolder.clearContext();
	 }
}
