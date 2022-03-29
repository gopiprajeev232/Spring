package com.prajeev.demo.controller;

import com.prajeev.demo.dto.CollegeDTO;
import com.prajeev.demo.entity.College;
import com.prajeev.demo.service.CollegeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {
    private CollegeService collegeService;

    private String collegeForm = "college-form";

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping("/list")
    public String getAllColleges(Model model) {
        List<CollegeDTO> colleges = collegeService.findAll();
        model.addAttribute("colleges", colleges);

        return "colleges-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        College college = new College();
        model.addAttribute("college", college);

        return collegeForm;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("collegeId") int id, Model model) {
        College college = collegeService.findById(id);
        model.addAttribute("college", college);

        return collegeForm;
    }

    @PostMapping("/save")
    public String saveCollege(@Valid @ModelAttribute("college") College college, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return collegeForm;
        }

        collegeService.save(college);

        return "redirect:/college/list";
    }

    @GetMapping("/delete")
    public String deleteCollege(@RequestParam("collegeId") int id) {
        collegeService.deleteById(id);

        return "redirect:/college/list";
    }
}
