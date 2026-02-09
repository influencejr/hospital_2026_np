package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutorRepository extends JpaRepository<Staff,Long> {
}
