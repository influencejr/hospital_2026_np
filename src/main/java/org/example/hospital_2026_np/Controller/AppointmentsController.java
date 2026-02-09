package org.example.hospital_2026_np.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Appointments;
import org.example.hospital_2026_np.Entity.Doctors;
import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Entity.Staff;
import org.example.hospital_2026_np.Repository.ExecutorRepository;
import org.example.hospital_2026_np.Repository.PatientRepository;
import org.example.hospital_2026_np.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppointmentsController {

    private final AppointmentsService appointmentsService;
    private final PatientsService patientsService;
    private final StaffService staffService;
    private final DoctorService  doctorService;
    private final ExecutorService executorService;



    @GetMapping("/appointments")
    public String getAppointments(Model model){

        List<Appointments> appointments = appointmentsService.findAll();
        model.addAttribute("appointments", appointments);
        appointments.forEach(a -> {
            System.out.println("Doctor: " + a.getDoctor());
        });


        return "appointments";
    }

    @GetMapping("/create_appointment")
    public String createAppointmentPage(){
        return "create-appointment";
    }

    @PostMapping("/create_appointment/create")
    public String createAppointment(@RequestParam(name = "patientID") Long patientID,
            @RequestParam(name = "doctorID") Long doctorID,
            @RequestParam(name = "appointmentType") String appointmentType,
            @RequestParam(name = "description") String description,
            Model model,
            HttpServletRequest request){

        Patients patient = patientsService.findById(patientID);
        Doctors doctor = doctorService.findById(doctorID);

        LocalDate localDate = LocalDate.now();
        Appointments appointment = new Appointments();
        appointment.setType(appointmentType);
        appointment.setDescription(description);
        appointment.setStatus("created");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setCreatedAt(new Date());
        appointment.setExecutedAt(null);
        appointment.setExecutedAt(null);

        appointmentsService.createNewAppointment(appointment);

        return "redirect:/appointments";


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
