package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patients, Long> {

    Patients findByUserId(Long userId);

}
