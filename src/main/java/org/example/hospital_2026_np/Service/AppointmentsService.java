package org.example.hospital_2026_np.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Appointments;
import org.example.hospital_2026_np.Entity.Doctors;
import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Repository.AppointmentRepository;
import org.example.hospital_2026_np.Repository.DoctorAbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentsService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorAvailabilityService doctorAvailabilityService;


    public List<Appointments> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointments findById(Long id) {
        return appointmentRepository.findById(id).get();
    }

    public void createNewAppointment(Appointments appointment) {
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Appointments appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void deleteAppointment(Appointments appointment) {
        appointmentRepository.delete(appointment);
    }

    public void deleteAllAppointments() {
        appointmentRepository.deleteAll();
    }

    @Transactional
    public Appointments book (Doctors doctor, Patients patient, String type, String description, LocalDateTime start, Duration duration) {
        LocalDateTime end = start.plus(duration);

        if (!doctorAvailabilityService.isDoctorAvailable(doctor.getId(), start, end)) {
            throw new IllegalStateException("Doctor is not available");
        }

        Appointments appointment = new Appointments();
        appointment.setDoctor(doctor);
        appointment.setStartTime(start);
        appointment.setEndTime(end);
        appointment.setStatus("CREATED");
        appointment.setDescription(description);
        appointment.setPatient(patient);
        appointment.setType(type);
        appointment.setDescription(description);

        return appointmentRepository.save(appointment);
    }

}
