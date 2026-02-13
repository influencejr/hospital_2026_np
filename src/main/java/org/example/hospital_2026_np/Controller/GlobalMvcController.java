package org.example.hospital_2026_np.Controller;

import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Entity.Users;
import org.example.hospital_2026_np.Service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalMvcController {

    @Autowired
    private PatientsService patientsService;

    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @ModelAttribute("userRoles")
    public Collection<String> getUserRoles(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {
            return Collections.emptyList();
        }
        return user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    @ModelAttribute("currentPatientId")
    public Long getCurrentPatientId(@AuthenticationPrincipal UserDetails user) {
        if (user == null) {
            return null;
        }

        Long userId = ((Users) user).getId();

        Patients patient = patientsService.findByUserId(userId);

        if (patient != null) {
            return patient.getId();
        }
        return null;
    }

}