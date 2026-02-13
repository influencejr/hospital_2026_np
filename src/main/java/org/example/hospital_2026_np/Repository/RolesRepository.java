package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}
