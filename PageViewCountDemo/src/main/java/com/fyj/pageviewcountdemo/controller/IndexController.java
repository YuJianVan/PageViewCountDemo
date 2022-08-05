package com.fyj.pageviewcountdemo.controller;

import com.fyj.pageviewcountdemo.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private PageService pageService;

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("page")
    public String page(@RequestParam("id") String id, Model model){
        int n = pageService.getViewCount(id);
        model.addAttribute("num",n);
        return "page";
    }
}
