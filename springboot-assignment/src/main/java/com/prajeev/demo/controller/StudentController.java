package com.prajeev.demo.controller;

import com.prajeev.demo.dto.ClubDTO;
import com.prajeev.demo.dto.StudentDTO;
import com.prajeev.demo.entity.Student;
import com.prajeev.demo.service.ClubService;
import com.prajeev.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClubService clubService;

    @GetMapping("/listByCollege")
    public String listStudentsByCollegeId(@RequestParam("collegeId") int id, Model model) {
        List<Student> students = studentService.findByCollegeId(id);

        model.addAttribute("students", students);
        model.addAttribute("collegeId", id);

        return "student-list-by-college";
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        List<StudentDTO> students = studentService.findAll();

        model.addAttribute("students", students);

        return "list-students";
    }

    @PostMapping("/showFormForAdd")
    public String showFormForAdd(@ModelAttribute("collegeId") int collegeId, Model model) {
        Student student = new Student();

        model.addAttribute("student", student);
        model.addAttribute("collegeId", collegeId);

        List<ClubDTO> clubs = clubService.findAll();

        model.addAttribute("clubs", clubs);

        return "student-form";
    }

    @PostMapping("/save")
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult,
                                @ModelAttribute("collegeId") int collegeId,
                                Model model) {
        if(bindingResult.hasErrors()) {

            model.addAttribute("collegeId", collegeId);

            List<ClubDTO> clubs = clubService.findAll();

            model.addAttribute("clubs", clubs);

            return "student-form";
        }

        studentService.save(student, collegeId);

        return "redirect:/students/listByCollege?collegeId="+collegeId;
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("collegeId") int collegeId, @ModelAttribute("studentId") int studentId, Model model) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);

        List<ClubDTO> clubs = clubService.findAll();
        model.addAttribute("clubs", clubs);

        model.addAttribute("collegeId", collegeId);

        return "update-student-form";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student, @ModelAttribute("collegeId") int collegeId) {
        studentService.save(student, collegeId);

        return "redirect:/students/listByCollege?collegeId="+collegeId;
    }

    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("studentId") int studentId, @ModelAttribute("collegeId") int collegeId) {
        studentService.deleteById(studentId);
        return "redirect:/students/listByCollege?collegeId="+collegeId;
    }
}
