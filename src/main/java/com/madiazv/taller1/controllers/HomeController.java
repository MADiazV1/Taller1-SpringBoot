package com.madiazv.taller1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Sitio web");
        model.addAttribute("subtitle", "Home - Page");
        return "home/index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "home/about";
    }
}
