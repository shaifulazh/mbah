package com.example.demo;



import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import jakarta.servlet.Filter;
@Controller
@RequestMapping
public class MainController {

	@RequestMapping(value= {"/home", "/"}, method = RequestMethod.GET)
	private String home() {
        //      List<Filter> filters = securityFilterChain.getFilters();
        // System.out.println("List of filters:");
        // for (Filter filter : filters) {
        //     System.out.println(filter.getClass().getSimpleName());
        // }
		return "home";
	}
    @RequestMapping(value= {"/hello"}, method = RequestMethod.GET)
	private String hello() {
		return "hello";
	}

    @RequestMapping(value= {"/login"}, method = RequestMethod.GET)
	private String login() {
		return "login";
	}

	@RequestMapping(value= {"/endpoint"}, method = RequestMethod.GET)
	private String endpoint() {
		return "endpoint";
	}



} 