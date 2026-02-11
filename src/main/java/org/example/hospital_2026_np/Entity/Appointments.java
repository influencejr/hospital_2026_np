package org.example.hospital_2026_np.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // medication / doctor_visit / procedure / operation

    private String description;

    private String status; // created / in_progress / completed

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;
    private Date executedAt;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @ToString.Exclude
    private Patients patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    @ToString.Exclude
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    @ToString.Exclude
    private Staff executor; // Хто виконав призначення



}
