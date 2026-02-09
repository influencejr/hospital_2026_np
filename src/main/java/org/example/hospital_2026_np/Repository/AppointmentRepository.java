package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointments, Long> {
}
