package org.example.hospital_2026_np.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private Integer age;
    private String gender;

    private String address;
    private Integer phoneNumber;

    private String status;

    private String finalDiagnosis;

    private Date admissionDate;
    private Date dischargeDate;

    @OneToMany
    private List<Appointments> appointments;

    @OneToOne
    private Users user;


}
