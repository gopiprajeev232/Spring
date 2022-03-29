package com.prajeev.demo.controller;

import com.prajeev.demo.entity.College;
import com.prajeev.demo.repository.CollegeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {
    private CollegeRepository collegeRepository;

    public CollegeController(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @GetMapping("/list")
    public String getAllColleges(Model model) {
        List<College> colleges = collegeRepository.findAll();
        model.addAttribute("colleges", colleges);

        return "colleges-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        College college = new College();
        model.addAttribute("college", college);

        return "college-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("collegeId") int id, Model model) {
        College college = collegeRepository.getById(id);
        model.addAttribute("college", college);

        return "college-form";
    }

    @PostMapping("/save")
    public String saveCollege(@Valid @ModelAttribute("college") College college, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "college-form";
        }

        collegeRepository.save(college);

        return "redirect:/college/list";
    }

    @GetMapping("/delete")
    public String deleteCollege(@RequestParam("collegeId") int id) {
        collegeRepository.deleteById(id);

        return "redirect:/college/list";
    }
}
