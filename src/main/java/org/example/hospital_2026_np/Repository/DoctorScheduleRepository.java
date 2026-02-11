package org.example.hospital_2026_np.Repository;

import java.time.DayOfWeek;
import java.util.Optional;
import org.example.hospital_2026_np.Entity.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule,Long> {

    Optional<DoctorSchedule> findByDoctorIdAndDayOfWeek(Long doctorId, String dayOfWeek);

}
