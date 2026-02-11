package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointments, Long> {

    @Query("""
            SELECT COUNT(a) > 0
            FROM Appointments a
            WHERE a.doctor.id = :doctorId
            AND a.status = 'created'
            AND :start < a.endTime
            AND :end > a.startTime   
            """)
    Boolean existsOverlappingAppointment(@Param("doctorId") Long doctorId,
                                         @Param("start") LocalDateTime start,
                                         @Param("end") LocalDateTime end);

}
