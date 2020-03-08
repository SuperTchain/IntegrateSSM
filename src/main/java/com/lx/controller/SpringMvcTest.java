package com.lx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringMvcTest {
    @GetMapping("/hello")
    public String returnHellp() {
        return "hello";
    }
}
