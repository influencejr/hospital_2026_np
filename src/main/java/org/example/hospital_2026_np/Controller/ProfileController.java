package org.example.hospital_2026_np.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Entity.Staff;
import org.example.hospital_2026_np.Entity.Users;
import org.example.hospital_2026_np.Service.PatientsService;
import org.example.hospital_2026_np.Service.StaffService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final PatientsService patientsService;
    private final StaffService staffService;

    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal Users user,
                             Model model) {
        if (user == null) {
            return "redirect:/login";
        }

        boolean isPatient = user.getRoles().stream().anyMatch(role -> role.getRole().equals("ROLE_PATIENT"));
        boolean isStaff = user.getRoles().stream().anyMatch(role -> role.getRole().equals("ROLE_DOCTOR") || role.getRole().equals("ROLE_NURSE"));

        if (isPatient) {
            Patients patient = patientsService.findByUserId(user.getId());
            model.addAttribute("person", patient);
            model.addAttribute("role", "patient");
        } else if (isStaff) {
            Staff staff = staffService.findByUserId(user.getId());
            model.addAttribute("person", staff);
            model.addAttribute("role", "staff");
        } else {
            model.addAttribute("role", "unknown");
        }

        model.addAttribute("user", user);

        return "profile";
    }

}
