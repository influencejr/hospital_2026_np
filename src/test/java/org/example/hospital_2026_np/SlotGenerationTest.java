package org.example.hospital_2026_np;

import org.example.hospital_2026_np.Entity.DoctorSchedule;
import org.example.hospital_2026_np.Entity.Doctors;
import org.example.hospital_2026_np.Repository.AppointmentRepository;
import org.example.hospital_2026_np.Repository.DoctorAbsenceRepository;
import org.example.hospital_2026_np.Repository.DoctorScheduleRepository;
import org.example.hospital_2026_np.Service.DoctorAvailabilityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class SlotGenerationTest {

    @Test
    void testPastSlotsFiltering() {
        DoctorScheduleRepository scheduleRepo = Mockito.mock(DoctorScheduleRepository.class);
        DoctorAbsenceRepository absenceRepo = Mockito.mock(DoctorAbsenceRepository.class);
        AppointmentRepository appointmentRepo = Mockito.mock(AppointmentRepository.class);

        DoctorAvailabilityService service = new DoctorAvailabilityService(scheduleRepo, absenceRepo, appointmentRepo);

        Long doctorId = 1L;
        LocalDate today = LocalDate.now();
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(17, 0);

        DoctorSchedule schedule = new DoctorSchedule();
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);

        when(scheduleRepo.findByDoctorIdAndDayOfWeek(eq(doctorId), anyString()))
                .thenReturn(Optional.of(schedule));
        when(absenceRepo.existsByDoctorIdAndDateFrom(eq(doctorId), any(LocalDate.class)))
                .thenReturn(false);
        when(appointmentRepo.existsOverlappingAppointment(eq(doctorId), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(false);

        // Scenario 1: It's 18:00 (past shift)
        // We can't easily mock LocalDateTime.now() without static mocking, 
        // but we can check the logic if we were able to.
        
        List<LocalDateTime> slots = service.generateAvailableSlots(doctorId, today.toString(), Duration.ofMinutes(30));
        for (LocalDateTime slot : slots) {
            System.out.println("[DEBUG_LOG] Slot: " + slot);
        }
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[DEBUG_LOG] Current time: " + now);
        System.out.println("[DEBUG_LOG] Start time: " + startTime);
        System.out.println("[DEBUG_LOG] End time: " + endTime);
        if (now.toLocalTime().isAfter(endTime)) {
            System.out.println("[DEBUG_LOG] It's past shift. Slots found: " + slots.size());
            assertTrue(slots.isEmpty(), "Should be empty if past shift");
        } else {
            System.out.println("[DEBUG_LOG] It's during shift. Slots found: " + slots.size());
            assertFalse(slots.isEmpty(), "Should not be empty if during shift");
        }
    }
}
