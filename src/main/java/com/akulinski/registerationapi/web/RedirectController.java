package com.akulinski.registerationapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("/signup")
    public String redirectToRoot() {
        return "redirect:/";
    }
}
