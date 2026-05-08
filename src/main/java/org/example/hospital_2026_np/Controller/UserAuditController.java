package org.example.hospital_2026_np.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.UserAudit;
import org.example.hospital_2026_np.Service.UserAuditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/audit")
@RequiredArgsConstructor
public class UserAuditController {

    private final UserAuditService userAuditService;

    @GetMapping
    public String auditPage(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String action,
            Model model
    ) {
        List<UserAudit> audits;

        if (username != null && !username.isEmpty()) {
            audits = userAuditService.getAuditsByUsername(username);
            model.addAttribute("filterType", "username");
            model.addAttribute("filterValue", username);
        } else if (action != null && !action.isEmpty()) {
            audits = userAuditService.getAuditsByAction(action);
            model.addAttribute("filterType", "action");
            model.addAttribute("filterValue", action);
        } else {
            audits = userAuditService.getAllAudits();
        }

        model.addAttribute("audits", audits);
        return "user-audit";
    }
}
