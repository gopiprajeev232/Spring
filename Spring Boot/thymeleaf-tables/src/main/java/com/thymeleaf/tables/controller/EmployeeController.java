package com.thymeleaf.tables.controller;

import com.thymeleaf.tables.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/list")
    public String getEmployees(Model model) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Gopi", "Prajeev", "gopi@gmail.com"));
        employees.add(new Employee(2, "Krishna", "Chaitanya", "kc@gmail.com"));
        employees.add(new Employee(3, "Pavan", "Ganesh", "pavan@gmail.com"));

        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
