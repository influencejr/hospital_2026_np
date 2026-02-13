package org.example.hospital_2026_np.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Entity.Roles;
import org.example.hospital_2026_np.Entity.Users;
import org.example.hospital_2026_np.Service.PatientsService;
import org.example.hospital_2026_np.Service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PatientsService patientsService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(@RequestParam (name = "message", defaultValue = " ") String message,
                                   Model model) {

        model.addAttribute("users", new Users());
        model.addAttribute("patients", new Patients());


        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(@Valid Users user,
                             BindingResult bindingResult1,
                             @Valid Patients patient,
                             BindingResult bindingResult2,
                             RedirectAttributes redirectAttributes) {

        if(userService.getUserFromDB(user.getUsername())) {
            redirectAttributes.addFlashAttribute("message", "User already exists");
            return "redirect:/login";
        }

        if (bindingResult1.hasErrors()) {
            return "registration";
        }
        if (bindingResult2.hasErrors()) {
            return "registration";
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Users user2 = userService.saveNewUser(user);

        user2.setRoles(Collections.singleton(new Roles(3L, "ROLE_PATIENT")));

        patient.setUser(user2);
        patientsService.savePatient(patient);

        return "redirect:/login";

    }


}
