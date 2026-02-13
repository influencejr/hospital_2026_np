package org.example.hospital_2026_np.Controller;

import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.MedicalRecords;
import org.example.hospital_2026_np.Service.MedicalRecordsService;
import org.example.hospital_2026_np.Service.PatientsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MedicalRecordsController {

    private final MedicalRecordsService medicalRecordsService;
    private final PatientsService patientsService;


    @GetMapping("/get_medical_records/{id}")
    public String getMedicalRecords(@PathVariable Long id, Model model) {

        List<MedicalRecords> medicalRecords = medicalRecordsService.findAllByPatientId(id);

        model.addAttribute("records", medicalRecords);

        return "medical-records";

    }

    @GetMapping("/create_medical_record")
    public String createMedicalRecordsPage(Model model) {

        return "create-medical-record";

    }

    @PostMapping("/create_medical_record")
    public String createMedicalRecord(@RequestParam(name = "patientId") Long patientId,
                                      @RequestParam(name = "appointmentDate")
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate,
                                      @RequestParam(name = "diagnosis") String diagnosis,
                                      @RequestParam(name = "prescription") String prescription,
                                      @RequestParam(name = "recommendation") String recommendation) {

        MedicalRecords medicalRecord = new MedicalRecords();
        medicalRecord.setPatient(patientsService.findById(patientId));
        medicalRecord.setAppointmentDate(appointmentDate);
        medicalRecord.setDiagnosis(diagnosis);
        medicalRecord.setPrescription(prescription);
        medicalRecord.setRecommendation(recommendation);

        medicalRecordsService.save(medicalRecord);

        return "redirect:/get_medical_records/" + patientId;
    }



}
