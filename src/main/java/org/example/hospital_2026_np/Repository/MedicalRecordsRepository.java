package org.example.hospital_2026_np.Repository;

import org.example.hospital_2026_np.Entity.MedicalRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Integer> {

    List<MedicalRecords> findAllByPatientId(Long patientId);

}
