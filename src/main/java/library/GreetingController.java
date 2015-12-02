package library;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
/*
	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public @ResponseBody User greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== in greeting ====");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return users.findOne(1);
	}

	@RequestMapping(path = "/greeting", method = RequestMethod.POST)
	public @ResponseBody User grPo(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== in greeting ====");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return users.findOne(1);
	}
*/
	/*@RequestMapping("/greeting-javaconfig")
	public @ResponseBody Greeting greetingWithJavaconfig(
			@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== in greeting ====");

		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}*/
}

@Controller
class JsApp {
}