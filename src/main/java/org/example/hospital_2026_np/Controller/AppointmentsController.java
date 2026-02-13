package org.example.hospital_2026_np.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.*;
import org.example.hospital_2026_np.Repository.ExecutorRepository;
import org.example.hospital_2026_np.Repository.PatientRepository;
import org.example.hospital_2026_np.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AppointmentsController {

    private final AppointmentsService appointmentsService;
    private final PatientsService patientsService;
    private final StaffService staffService;
    private final DoctorService  doctorService;
    private final ExecutorService executorService;
    private final DoctorAvailabilityService doctorAvailabilityService;
    private final UserService userService;



    @GetMapping("/appointments/{id}")
    public String getAppointmentsWithId(@PathVariable Long id,
            Model model){

        List<Appointments> appointments = appointmentsService.findAllByPatientId(id);
        model.addAttribute("appointments", appointments);
        appointments.forEach(a -> {
            System.out.println("Doctor: " + a.getDoctor());
        });


        return "appointments";
    }


    @GetMapping("/appointments")
    public String getAppointments(Model model){

        List<Appointments> appointments = appointmentsService.findAll();
        model.addAttribute("appointments", appointments);
        appointments.forEach(a -> {
            System.out.println("Doctor: " + a.getDoctor());
        });


        return "appointments";
    }


    @GetMapping("/create_appointment/doctor_id/{id}")
    public String createAppointmentPage(@PathVariable("id") Long id,
                                        Model model,
                                        HttpServletRequest request){

        model.addAttribute("doctorId", id);

        Doctors doctor = doctorService.findById(id);
        Map<String, List<String>> doctorSlotsMap = new HashMap<>();
        LocalDate now = LocalDate.now();
        Duration slotDuration = Duration.ofMinutes(30);
        String specialization;
        specialization = doctorService.findById(doctor.getId()).getSpecialization();

        HttpSession session = request.getSession();

        session.setAttribute("lastViewedDoctorId", id);
        session.setAttribute("lastViewedDoctorName", doctor.getFirstName() + " " + doctor.getLastName());



        if ("surgeon".equals(specialization)) {
            slotDuration = Duration.ofMinutes(120);
        } else if ("therapist".equals(specialization)) {
            slotDuration = Duration.ofMinutes(25);
        } else {
            slotDuration = Duration.ofMinutes(15);
        }


        List<LocalDateTime> slots = doctorAvailabilityService.generateAvailableSlots(doctor.getId(), String.valueOf(now), slotDuration);

        List<String> slotStrings = slots.stream().map(slot -> slot.toLocalTime()
                .format(DateTimeFormatter.ofPattern("HH:mm"))).toList();
        doctorSlotsMap.put(String.valueOf(doctor.getId()), slotStrings);

        model.addAttribute("slots", slotStrings);

        return "create-appointment";
    }

    @PostMapping("/create_appointment/doctor_id/{id}")
    public String createAppointment(@PathVariable Long id,
            @RequestParam(name = "appointmentType") String appointmentType,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "appointmentTime") String appointmentTime,
            Model model,
            HttpServletRequest request){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) userService.loadUserByUsername(authentication.getName());

        if(user == null) {
            return "redirect:/login";
        }

        Patients patient = patientsService.findByUserId(user.getId());

        HttpSession session = request.getSession();

        Doctors doctor = (Doctors) doctorService.findById(id);

        LocalTime time = LocalTime.parse(appointmentTime);
        LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now(), time);

        LocalDateTime endDateTime = startDateTime.plusMinutes(15);

        Appointments appointment = new Appointments();
        appointment.setType(appointmentType);
        appointment.setDescription(description);
        appointment.setStatus("created");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setCreatedAt(new Date());
        appointment.setExecutedAt(null);
        appointment.setStartTime(startDateTime);
        appointment.setEndTime(endDateTime);


        appointmentsService.createNewAppointment(appointment);

        return "redirect:/appointments/" + patient.getId();


    }

    @GetMapping("/update_appointment")
    public String updateAppointmentPage() {
        return "edit-appointment";
    }

    @PostMapping("/update_appointment/update")
    public String updateAppointment(@RequestParam(name = "id") Long ID,
                                    @RequestParam(name = "type", required = false) String appointmentType ,
                                    @RequestParam(name = "description", required = false) String description,
                                    @RequestParam(name = "patientID", required = false) Long patientID,
                                    @RequestParam(name = "doctorID", required = false) Long doctorID,
                                    @RequestParam(name = "status", required = false) String status,
                                    @RequestParam(name = "executorID", required = false) Long executorID,
                                    Model model,
                                    HttpServletRequest request){

        Appointments appointment = appointmentsService.findById(ID);
        if (appointmentType != null && !appointmentType.isEmpty()) {
            appointment.setType(appointmentType);
        }

        if (description != null && !description.isEmpty()) {
            appointment.setDescription(description);
        }

        if (status != null && !status.isEmpty()) {
            appointment.setStatus(status);
        }

        if (patientID != null) {
            appointment.setPatient(patientsService.findById(patientID));
        }

        if (doctorID != null) {
            appointment.setDoctor(doctorService.findById(doctorID));
        }

        if (executorID != null) {
            appointment.setExecutor(executorService.findById(executorID));
        }

        appointmentsService.updateAppointment(appointment);

        return "redirect:/appointments";
    }


    @GetMapping("/delete_appointment")
    public String deleteAppointmentPage() {
        return "delete-appointment";
    }

    @PostMapping("/delete_appointment/delete")
    public String deleteAppointment(@RequestParam(name = "id") Long ID) {
        appointmentsService.deleteAppointmentById(ID);

        return  "redirect:/appointments";
    }

}
