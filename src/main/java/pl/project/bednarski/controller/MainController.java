package pl.project.bednarski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.bednarski.model.Profiles;
import pl.project.bednarski.model.Role;
import pl.project.bednarski.utils.Tools;

import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
@RequestMapping(path = "/")
public class MainController {

    private final ProfileRepository profileRepository;

    @Autowired
    public MainController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("profiles", profileRepository.findAll());
        return "index";
    }
    @GetMapping("/add-form")
    public String gotoProfileAddForm(Profiles profile) {
        return "profile-add-form";
    }
    @PostMapping("/add")
    public String addProfile(@Valid Profiles profile, BindingResult result, Model model) {
        System.out.println("--addProfile--");

        profile.setPassword(Tools.encryptPassword(profile.getPassword()));
        profile.setIp(Tools.showIP());
        profile.setRole(Role.user);


        System.out.println(profile.toString());

        if(result.hasErrors()) {
            System.out.println(result.getAllErrors());
            System.out.println("Coś poszło nie tak.");
            return "profile-add-form";
        }
        profileRepository.save(profile);
        model.addAttribute("profiles", profileRepository.findAll());
        return "redirect:list";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        System.out.println("--showUpdateForm--");

        Profiles profile = profileRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Nieprawidłowe id profilu: " + id));
        System.out.println(profile.toString());
        model.addAttribute("profile",profile);
        return "profile-update-form";
    }
    @PostMapping("/update/{id}")
    public String updateProfiles(@PathVariable("id")long id, Profiles profile, BindingResult result, Model model){
        System.out.println("--updateProfile--");

        profile.setIp(Tools.showIP());
        profile.setRole(Role.user);
        profile.setRegstamp(new Timestamp(System.currentTimeMillis()));

        System.out.println(profile.toString());
        if(result.hasErrors()) {
            profile.setId(id);
            System.out.println("Coś poszło nie tak");
            System.out.println(result.getAllErrors());
            return "profile-update-form";
        }
        profileRepository.save(profile);
        model.addAttribute("profile", profileRepository.findAll());
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteProfile(@PathVariable("id") long id, Model model){
        System.out.println("--deleteProfile--");

        Profiles profile = profileRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nieprawidłowy id profilu: " + id));
        profileRepository.delete(profile);
        model.addAttribute("profile",profileRepository.findAll());

        System.out.println(profile.toString());
        return "index";
    }
}
