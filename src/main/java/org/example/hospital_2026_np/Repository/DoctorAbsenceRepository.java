package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.DoctorAbsence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DoctorAbsenceRepository extends JpaRepository<DoctorAbsence,Long> {

    Boolean existsByDoctorIdAndDateFrom(Long doctorId, LocalDate dateFrom);

}
