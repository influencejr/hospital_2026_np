package org.example.hospital_2026_np.Service;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Doctors;
import org.example.hospital_2026_np.Entity.Staff;
import org.example.hospital_2026_np.Repository.ExecutorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecutorService {

    private final ExecutorRepository executorRepository;

    public Staff findById(Long id) {
        return executorRepository.findById(id).get();
    }

}
