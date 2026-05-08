package org.example.hospital_2026_np.Service;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.UserAudit;
import org.example.hospital_2026_np.Repository.UserAuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAuditService {

    private final UserAuditRepository userAuditRepository;

    public void logAction(String username, String action, String details) {
        UserAudit audit = new UserAudit(username, action, details);
        userAuditRepository.save(audit);
    }

    public List<UserAudit> getAllAudits() {
        return userAuditRepository.findAllByOrderByTimestampDesc();
    }

    public List<UserAudit> getAuditsByUsername(String username) {
        return userAuditRepository.findByUsernameOrderByTimestampDesc(username);
    }

    public List<UserAudit> getAuditsByAction(String action) {
        return userAuditRepository.findByActionOrderByTimestampDesc(action);
    }

    public List<UserAudit> getAuditsByDateRange(LocalDateTime start, LocalDateTime end) {
        return userAuditRepository.findByTimestampBetweenOrderByTimestampDesc(start, end);
    }
}
