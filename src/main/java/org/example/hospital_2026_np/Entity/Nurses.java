package org.example.hospital_2026_np.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "nurses")
public class Nurses extends Staff {

}
