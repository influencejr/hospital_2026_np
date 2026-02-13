package org.example.hospital_2026_np.Service;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.Patients;
import org.example.hospital_2026_np.Repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientsService {

    private final PatientRepository patientRepository;

    public Patients findById(Long id) {
        return patientRepository.findById(id).get();
    }

    public Patients savePatient(Patients patient) {
        return patientRepository.save(patient);
    }

    public Patients findByUserId(Long userId) {
        return  patientRepository.findByUserId(userId);
    }




}
