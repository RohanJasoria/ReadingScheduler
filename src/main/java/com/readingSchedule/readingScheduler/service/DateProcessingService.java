package com.readingSchedule.readingScheduler.service;

public interface DateProcessingService {
    String getCurrentDate();
    String getDatePastOneDay();
    String getDatePastThreeDays();
    String getDatePastSixDays();
}
