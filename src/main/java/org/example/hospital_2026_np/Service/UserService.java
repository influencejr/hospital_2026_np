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


}
