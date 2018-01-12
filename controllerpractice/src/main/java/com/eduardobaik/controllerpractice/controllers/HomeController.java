package com.eduardobaik.controllerpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
        @RequestMapping("")
        public String index() {
        		System.out.println("index link works");
        		return "index.html";
        }
        @RequestMapping("myProjects")
        public String portfolio() {
        		System.out.println("projects link works");
        		return "Projects.html";
        }
        @RequestMapping("aboutMe")
        public String me() {
        		System.out.println("me link works");
        		return "Me.html";
        }
}

