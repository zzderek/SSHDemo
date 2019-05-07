package com.derek.controller;

import com.derek.service.BookService;
import com.derek.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class );
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/index")
    public String printHello(ModelMap model) {
        logger.info("访问/index");
        model.addAttribute("message", "Hello Spring MVC Framework!");

        return "index";
    }

    @GetMapping(value = "/user")
    public String getUser(ModelMap model) {

        logger.info("访问/user");
        List list =  userService.getUserById(1);
        model.addAttribute("message", list);

        return "index";
    }


}
