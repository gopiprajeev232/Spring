package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.classes.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        Employee emp = new Employee();
        theModel.addAttribute("employee", emp);
        return "employee-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("employee") Employee employee) {
        for(String language : employee.getFamiliarLanguages()) {
            System.out.println(language);
        }
        return "emp-confirmation";
    }
}
