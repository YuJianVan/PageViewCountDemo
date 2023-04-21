package com.fyj.quartzdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/getcron")
    public String getCron(Model model, HttpServletRequest request){
        String text = request.getParameter("cronText");
        System.out.println(text);
        model.addAttribute("cronText",text);
        return "redirect:/";
    }
}
