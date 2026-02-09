package org.example.hospital_2026_np.Service;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Doctors;
import org.example.hospital_2026_np.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctors findById(Long id) {
        return doctorRepository.findById(id).get();
    }

}
