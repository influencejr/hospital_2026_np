package org.example.hospital_2026_np.Service;


import lombok.RequiredArgsConstructor;
import org.example.hospital_2026_np.Entity.DoctorSchedule;
import org.example.hospital_2026_np.Repository.AppointmentRepository;
import org.example.hospital_2026_np.Repository.DoctorAbsenceRepository;
import org.example.hospital_2026_np.Repository.DoctorScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DoctorAvailabilityService {

    private final DoctorScheduleRepository doctorScheduleRepository;
    private final DoctorAbsenceRepository doctorAbsenceRepository;
    private final AppointmentRepository appointmentRepository;

    public Boolean isDoctorAvailable(Long doctorId, LocalDateTime start, LocalDateTime end) {
        Boolean absent = doctorAbsenceRepository.existsByDoctorIdAndDateFrom(doctorId, start.toLocalDate());
        if (Boolean.TRUE.equals(absent)) return false;

        String dowString = start.getDayOfWeek().name();
        DoctorSchedule schedule = doctorScheduleRepository.findByDoctorIdAndDayOfWeek(doctorId, dowString).orElse(null);
        if (schedule == null) return false;

        if (start.toLocalTime().isBefore(schedule.getStartTime()) || end.toLocalTime().isAfter(schedule.getEndTime())) {
            return false;
        }

        Boolean busy = appointmentRepository.existsOverlappingAppointment(doctorId, start, end);
        return !Boolean.TRUE.equals(busy);


    }

    public List<LocalDateTime> generateAvailableSlots(
            Long doctorId,
            String date,
            Duration slotDuration
    ) {
        List<LocalDateTime> slots = new ArrayList<>();

        LocalDate localDate = LocalDate.parse(date);
        String dayOfWeekName = localDate.getDayOfWeek().name();
        LocalDateTime now = LocalDateTime.now();

        DoctorSchedule schedule = doctorScheduleRepository
                .findByDoctorIdAndDayOfWeek(doctorId, dayOfWeekName)
                .orElse(null);

        if (schedule == null) {
            return slots;
        }

        LocalDateTime current = LocalDateTime.of(localDate, schedule.getStartTime());
        LocalDateTime endOfDay = LocalDateTime.of(localDate, schedule.getEndTime());

        while (current.plus(slotDuration).isBefore(endOfDay)
                || current.plus(slotDuration).equals(endOfDay)) {

            if (isDoctorAvailable(doctorId, current, current.plus(slotDuration))) {
                if (!current.isBefore(now)) {
                    slots.add(current);
                }
            }

            current = current.plus(slotDuration);
        }

        return slots;
    }



}
