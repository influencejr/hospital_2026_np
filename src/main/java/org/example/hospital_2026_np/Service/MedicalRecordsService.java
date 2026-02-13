package org.example.hospital_2026_np.Service;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.MedicalRecords;
import org.example.hospital_2026_np.Repository.MedicalRecordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordsService {

    private final MedicalRecordsRepository medicalRecordsRepository;

    public List<MedicalRecords> findAllByPatientId(Long patientId) {
        return medicalRecordsRepository.findAllByPatientId(patientId);
    }

    public MedicalRecords save(MedicalRecords medicalRecords) {
        return medicalRecordsRepository.save(medicalRecords);
    }

}
