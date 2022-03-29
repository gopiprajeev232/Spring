package com.prajeev.demo.controller;

import com.prajeev.demo.entity.Club;
import com.prajeev.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    private String clubForm = "club-form";

    @GetMapping("/list")
    public String getClubs(Model model) {

        model.addAttribute("clubs", clubService.findAll());

        return "list-clubs";
    }

    @GetMapping("/showFormForAdd")
    public String addNewClub(Model model) {
        model.addAttribute("club", new Club());

        return clubForm;
    }

    @PostMapping("/save")
    public String saveClub(@Valid @ModelAttribute("club") Club club, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return clubForm;
        }

        clubService.save(club);

        return "redirect:/clubs/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("clubId") int clubId, Model model) {
        Club club = clubService.findById(clubId);

        model.addAttribute("club", club);

        return clubForm;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("clubId") int clubId) {
        clubService.deleteById(clubId);

        return "redirect:/clubs/list";
    }
}
