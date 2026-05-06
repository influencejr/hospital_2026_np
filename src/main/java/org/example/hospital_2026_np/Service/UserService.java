package org.example.hospital_2026_np.Service;


import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Entity.Roles;
import org.example.hospital_2026_np.Entity.Users;
import org.example.hospital_2026_np.Repository.PatientRepository;
import org.example.hospital_2026_np.Repository.RolesRepository;
import org.example.hospital_2026_np.Repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final PatientRepository patientRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

    public Boolean getUserFromDB(String username) {
        return (usersRepository.findByUsername(username) != null);
    }

    public Users saveNewUser(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    public List<Roles> findAllRoles() {
        return rolesRepository.findAll();
    }

    public void updateUserRole(Long userId, Long roleId) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Roles role = rolesRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().clear();
        user.getRoles().add(role);
        usersRepository.save(user);
    }

    public void createAdminUser(String username, String password, Long roleId) {
        Roles role = rolesRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        usersRepository.save(user);
    }
}
