package com.example.demo.controller;

import com.example.demo.domain.model.InfoTable;
import com.example.demo.domain.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{
    @Autowired
    SearchService searchService;
    @RequestMapping("/hello")
    public String hello(Model model)
    {
        InfoTable infoTable = searchService.selectOne(1);
        model.addAttribute("Title", infoTable.getTitle());
        return "hello";
    }
}
