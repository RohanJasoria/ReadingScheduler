package com.readingSchedule.readingScheduler.service.impl;

import com.readingSchedule.readingScheduler.entity.UrlInfo;
import com.readingSchedule.readingScheduler.repository.UrlInfoRepo;
import com.readingSchedule.readingScheduler.service.DateProcessingService;
import com.readingSchedule.readingScheduler.service.FetchUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchUrlServiceImpl implements FetchUrlService {
    @Autowired
    private DateProcessingService dateProcessingService;

    private final UrlInfoRepo urlInfoRepo;

    @Override
    public List<String> fetchUrls() {
        List<String> urls = new ArrayList<>();

        String datePastOneDay = dateProcessingService.getDatePastOneDay();
        String datePastThreeDays = dateProcessingService.getDatePastThreeDays();
        String datePastSixDays = dateProcessingService.getDatePastSixDays();

        List<UrlInfo> pastOneDayUrls = urlInfoRepo.findBySyncDate(datePastOneDay);
        List<UrlInfo> pastThreeDayUrls = urlInfoRepo.findBySyncDate(datePastThreeDays);
        List<UrlInfo> pastSixDayUrls = urlInfoRepo.findBySyncDate(datePastSixDays);

        for(UrlInfo urlInfo : pastOneDayUrls) {
            urls.add(urlInfo.getUrl());
        }
        for(UrlInfo urlInfo : pastThreeDayUrls) {
            urls.add(urlInfo.getUrl());
        }
        for(UrlInfo urlInfo : pastSixDayUrls) {
            urls.add(urlInfo.getUrl());
        }

        return urls;
    }
}
