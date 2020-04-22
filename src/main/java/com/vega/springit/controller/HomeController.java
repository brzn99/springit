package com.vega.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-controller
@Controller
public class HomeController
{
    @GetMapping ("/hello")
    public String handle(Model model)
    {
        model.addAttribute("message", "Hello World!");
        return "index"; //looks for a template named index
    }

    @RequestMapping(path = "/")
    public String home()
    {
        //if you use @RestController, it will return the string
        return "Hello, Spring Boot 2";
    }

    @RequestMapping(path = "/template")
    public String home2()
    {
        //if you use @Controller, it will return /templates/index.html
        return "index";
    }
    @RequestMapping(path = "/template2", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public String home3()
    {
        //if you use @Controller, it will return /templates/index.html
        return "index";
    }

}
