package org.example.hospital_2026_np.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "doctors")
public class Doctors extends Staff {

    private String specialization;

    @OneToMany
    private List<Appointments> appointments;

}
