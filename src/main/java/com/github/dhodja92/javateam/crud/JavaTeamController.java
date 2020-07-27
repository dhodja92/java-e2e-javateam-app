package com.github.dhodja92.javateam.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class JavaTeamController {

    private final JavaTeamRepository javaTeamRepository;

    public JavaTeamController(
            JavaTeamRepository javaTeamRepository
    ) {
        this.javaTeamRepository = javaTeamRepository;
    }

    @GetMapping("index")
    public String getMembers(
            Model model
    ) {
        model.addAttribute("members", this.javaTeamRepository.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateMemberForm(
            Model model
    ) {
        model.addAttribute("member", new CreateJavaTeamMemberRequest());
        return "add-member";
    }

    @PostMapping("/create")
    public String create(
            @Valid CreateJavaTeamMemberRequest teamMember,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("member", new CreateJavaTeamMemberRequest());
            return "add-member";
        }

        this.javaTeamRepository.create(teamMember);
        model.addAttribute("members", this.javaTeamRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(
            @PathVariable("id") int id,
            Model model
    ) {
        JavaTeamMember member = this.javaTeamRepository.findById(id);

        UpdateJavaTeamMemberRequest updateJavaTeamMemberRequest = UpdateJavaTeamMemberRequest.builder()
                .id(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .build();

        model.addAttribute("member", updateJavaTeamMemberRequest);
        return "update-member";
    }

    @PostMapping("/update/{id}")
    public String updateMember(
            @PathVariable("id") int id,
            @Valid UpdateJavaTeamMemberRequest member,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "update-member";
        }

        this.javaTeamRepository.update(member);
        model.addAttribute("members", this.javaTeamRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(
            @PathVariable("id") int id,
            Model model
    ) {
        JavaTeamMember member = this.javaTeamRepository.findById(id);
        this.javaTeamRepository.remove(member);

        model.addAttribute("members", this.javaTeamRepository.findAll());
        return "redirect:/index";
    }
}
