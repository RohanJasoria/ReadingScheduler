package com.readingSchedule.readingScheduler.service.impl;

import com.readingSchedule.readingScheduler.entity.UrlInfo;
import com.readingSchedule.readingScheduler.repository.UrlInfoRepo;
import com.readingSchedule.readingScheduler.response.ReadingResponse;
import com.readingSchedule.readingScheduler.response.ReadsInfo;
import com.readingSchedule.readingScheduler.service.DateProcessingService;
import com.readingSchedule.readingScheduler.service.FetchUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class FetchUrlServiceImpl implements FetchUrlService {
    @Autowired
    private DateProcessingService dateProcessingService;

    private final UrlInfoRepo urlInfoRepo;

    @Override
    public ReadingResponse fetchReadingResponse() {
        ReadingResponse readingResponse = new ReadingResponse();
        List<ReadsInfo> readsInfoList = new ArrayList<>();

        String datePastOneDay = dateProcessingService.getDatePastOneDay();
        String datePastThreeDays = dateProcessingService.getDatePastThreeDays();
        String datePastSixDays = dateProcessingService.getDatePastSixDays();

        List<UrlInfo> pastOneDayUrls = urlInfoRepo.findBySyncDate(datePastOneDay);
        List<UrlInfo> pastThreeDayUrls = urlInfoRepo.findBySyncDate(datePastThreeDays);
        List<UrlInfo> pastSixDayUrls = urlInfoRepo.findBySyncDate(datePastSixDays);

        populateReadsInfoList(pastOneDayUrls, readsInfoList);
        populateReadsInfoList(pastThreeDayUrls, readsInfoList);
        populateReadsInfoList(pastSixDayUrls, readsInfoList);

        readingResponse.setReadsInfoList(readsInfoList);
        return readingResponse;
    }

    private static void populateReadsInfoList(List<UrlInfo> urlInfoList, List<ReadsInfo> readsInfoList) {
        if(isNull(urlInfoList) || urlInfoList.isEmpty()) {
            return;
        }
        for(UrlInfo urlInfo : urlInfoList) {
            ReadsInfo readsInfo = new ReadsInfo();
            readsInfo.setUrl(urlInfo.getUrl());
            readsInfo.setStartInfo(urlInfo.getStartInfo());
            readsInfo.setEndInfo(urlInfo.getEndInfo());
            readsInfoList.add(readsInfo);
        }
    }
}
