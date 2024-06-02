package com.readingSchedule.readingScheduler.service.impl;

import com.readingSchedule.readingScheduler.service.DateProcessingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateProcessingServiceImpl implements DateProcessingService {
    @Override
    public String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return formatter.format(currentDateTime);
    }

    @Override
    public String getDatePastOneDay() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return formatter.format(currentDateTime.plusDays(-1));
    }

    @Override
    public String getDatePastThreeDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return formatter.format(currentDateTime.plusDays(-3));
    }

    @Override
    public String getDatePastSixDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime currentDateTime = LocalDateTime.now();
        return formatter.format(currentDateTime.plusDays(-6));
    }
}
