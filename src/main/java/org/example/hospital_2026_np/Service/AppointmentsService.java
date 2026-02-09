package org.example.hospital_2026_np.Service;


import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Appointments;
import org.example.hospital_2026_np.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentsService {

    private final AppointmentRepository appointmentRepository;


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

}
