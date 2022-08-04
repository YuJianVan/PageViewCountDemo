package com.fyj.pageviewcountdemo.controller;

import com.fyj.pageviewcountdemo.service.ViewCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    ViewCountService viewCountService;

    @GetMapping("index")
    public String index(){
        /*int n=viewCountService.getViewCount();
        model.addAttribute("num",n);*/
        return "index";
    }
}
