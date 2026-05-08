package org.example.hospital_2026_np.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final org.example.hospital_2026_np.Service.UserAuditService userAuditService;

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("roles", userService.findAllRoles());
        return "admin";
    }

    @PostMapping("/create_user")
    public String createUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam Long roleId) {
        userService.createAdminUser(username, password, roleId);
        userAuditService.logAction("admin", "CREATE_USER", "Created user: " + username + " with roleId: " + roleId);
        return "redirect:/admin";
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        userAuditService.logAction("admin", "DELETE_USER", "Deleted user with ID: " + id);
        return "redirect:/admin";
    }

    @PostMapping("/update_role")
    public String updateRole(@RequestParam Long userId,
                             @RequestParam Long roleId) {
        userService.updateUserRole(userId, roleId);
        userAuditService.logAction("admin", "UPDATE_USER", "Updated role for userId: " + userId + " to roleId: " + roleId);
        return "redirect:/admin";
    }
}
