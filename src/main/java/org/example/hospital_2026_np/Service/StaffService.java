package org.example.hospital_2026_np.Service;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Staff;
import org.example.hospital_2026_np.Repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    public Staff findById(Long id){
        return staffRepository.findById(id).get();
    }

    public List<Staff> findAll(){
        return staffRepository.findAll();
    }

}
