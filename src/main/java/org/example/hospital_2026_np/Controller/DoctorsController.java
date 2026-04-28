package org.example.hospital_2026_np.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Appointments;
import org.example.hospital_2026_np.Entity.Doctors;
import org.example.hospital_2026_np.Entity.Staff;
import org.example.hospital_2026_np.Service.DoctorAvailabilityService;
import org.example.hospital_2026_np.Service.DoctorService;
import org.example.hospital_2026_np.Service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DoctorsController {

    private final StaffService staffService;
    private final DoctorAvailabilityService doctorAvailabilityService;
    private final DoctorService doctorService;

    @GetMapping("/available_doctors")
    public String availableDoctorsPage(Model model){


        List<Staff> staff = staffService.findAll();
        model.addAttribute("staff", staff);

        Map<String, List<String>> doctorSlotsMap = new HashMap<>();
        LocalDate now = LocalDate.now();
        Duration slotDuration = Duration.ofMinutes(30);
        String specialization;

        for (Staff worker : staff) {

            Doctors docEntity;
            try {
                docEntity = doctorService.findById(worker.getId());
            } catch (Exception e) {
                continue;
            }

            if (docEntity == null) {
                continue;
            }
            specialization = docEntity.getSpecialization();
            System.out.println(specialization);


            if ("surgeon".equals(specialization)) {
                slotDuration = Duration.ofMinutes(120);
            } else if ("therapist".equals(specialization)) {
                slotDuration = Duration.ofMinutes(25);
            } else {
                slotDuration = Duration.ofMinutes(30); // Changed from 15 to 30 as default
            }


            List<LocalDateTime> slots = doctorAvailabilityService.generateAvailableSlots(worker.getId(), String.valueOf(now), slotDuration);

            List<String> slotStrings = slots.stream().map(slot -> slot.toLocalTime()
                    .format(DateTimeFormatter.ofPattern("HH:mm"))).toList();
            doctorSlotsMap.put(String.valueOf(worker.getId()), slotStrings);
        }

        if (doctorSlotsMap.values().stream().allMatch(List::isEmpty)) {
            // If all slots are empty for today (shift ended), show for tomorrow as fallback
            LocalDate tomorrow = LocalDate.now().plusDays(1);
            for (Staff worker : staff) {
                Doctors docEntity;
                try {
                    docEntity = doctorService.findById(worker.getId());
                } catch (Exception e) {
                    continue;
                }
                if (docEntity == null) continue;
                
                specialization = docEntity.getSpecialization();
                if ("surgeon".equals(specialization)) {
                    slotDuration = Duration.ofMinutes(120);
                } else if ("therapist".equals(specialization)) {
                    slotDuration = Duration.ofMinutes(25);
                } else {
                    slotDuration = Duration.ofMinutes(30);
                }

                List<LocalDateTime> nextDaySlots = doctorAvailabilityService.generateAvailableSlots(worker.getId(), String.valueOf(tomorrow), slotDuration);
                if (!nextDaySlots.isEmpty()) {
                    List<String> slotStrings = nextDaySlots.stream().map(slot -> slot.toLocalTime()
                            .format(DateTimeFormatter.ofPattern("HH:mm"))).toList();
                    doctorSlotsMap.put(String.valueOf(worker.getId()), slotStrings);
                }
            }
            model.addAttribute("viewDate", "Завтра");
        } else {
            model.addAttribute("viewDate", "Сьогодні");
        }

        model.addAttribute("slots", doctorSlotsMap);



        return "available-doctors";
    }



}
