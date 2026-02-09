package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {
}
