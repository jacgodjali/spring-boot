package com.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String helloGet(@RequestParam(value = "message", defaultValue = "HELLO") String message) {
		return "Your message: " + message;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	@ResponseBody
	public String helloPost(@RequestBody String message) {
		return "Your message: " + message;
	}

	@RequestMapping(value = "hello/{message}", method = RequestMethod.PUT)
	@ResponseBody
	public String helloPut(@PathVariable String message) {
		return "Your message is: " + message;
	}

}
