package com.pharmacy.mediconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST})
public class HomeController {

	@RequestMapping("/")
    public String index() {
        return "index.html";
    }
}
