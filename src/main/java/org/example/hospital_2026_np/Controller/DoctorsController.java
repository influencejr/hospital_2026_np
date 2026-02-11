package org.example.hospital_2026_np.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Appointments;
import org.example.hospital_2026_np.Entity.Staff;
import org.example.hospital_2026_np.Service.DoctorAvailabilityService;
import org.example.hospital_2026_np.Service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DoctorsController {

    private final StaffService staffService;
    private final DoctorAvailabilityService doctorAvailabilityService;

    @GetMapping("/available_doctors")
    public String availableDoctorsPage(Model model){


        List<Staff> staff = staffService.findAll();
        model.addAttribute("staff", staff);

        Map<String, List<String>> doctorSlotsMap = new HashMap<>();
        LocalDate now = LocalDate.now();
        Duration slotDuration = Duration.ofMinutes(30);

        for (Staff doctor : staff) {
            List<LocalDateTime> slots = doctorAvailabilityService.generateAvailableSlots(doctor.getId(), String.valueOf(now), slotDuration);

            List<String> slotStrings = slots.stream().map(slot -> slot.toLocalTime()
                    .format(DateTimeFormatter.ofPattern("HH:mm"))).toList();
            doctorSlotsMap.put(String.valueOf(doctor.getId()), slotStrings);
        }

        model.addAttribute("slots", doctorSlotsMap);



        return "available-doctors";
    }



}
