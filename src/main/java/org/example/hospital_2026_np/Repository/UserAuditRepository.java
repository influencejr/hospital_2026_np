package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {
    List<UserAudit> findByUsernameOrderByTimestampDesc(String username);
    List<UserAudit> findByActionOrderByTimestampDesc(String action);
    List<UserAudit> findByTimestampBetweenOrderByTimestampDesc(LocalDateTime start, LocalDateTime end);
    List<UserAudit> findAllByOrderByTimestampDesc();
}
