package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    @RequestMapping("/addStudent")
    public String addStudent() {
        return "addStudent";
    }

//    HttpServletRequest example to read inputs
    @RequestMapping("/processStudentForm")
    public String showWelcomeMessage(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        model.addAttribute("stuName", name);
        return "studentWelcome";
    }

    // @RequestParam example
    @RequestMapping("/processStudentFormVer2")
    public String showWelcomeMessage(@RequestParam("studentName") String studentName, Model model) {
        model.addAttribute("stuName", studentName);
        return "studentWelcomeVer2";
    }
}
