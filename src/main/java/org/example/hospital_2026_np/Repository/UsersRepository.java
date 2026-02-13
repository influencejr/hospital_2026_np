package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

}
