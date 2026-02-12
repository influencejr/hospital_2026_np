package org.example.hospital_2026_np.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.MedicalRecords;
import org.example.hospital_2026_np.Service.MedicalRecordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MedicalRecordsController {

    private final MedicalRecordsService medicalRecordsService;


    @GetMapping("/get_medical_records/{id}")
    public String getMedicalRecords(@PathVariable Long id, Model model) {

        List<MedicalRecords> medicalRecords = medicalRecordsService.findAllByPatientId(id);

        model.addAttribute("records", medicalRecords);

        return "medical-records";

    }



}
