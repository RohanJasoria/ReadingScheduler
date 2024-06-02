package com.readingSchedule.readingScheduler.service.impl;

import com.readingSchedule.readingScheduler.entity.UrlInfo;
import com.readingSchedule.readingScheduler.repository.UrlInfoRepo;
import com.readingSchedule.readingScheduler.request.UrlInfoRequest;
import com.readingSchedule.readingScheduler.service.DateProcessingService;
import com.readingSchedule.readingScheduler.service.SyncUrlInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class SyncUrlInfoServiceImpl implements SyncUrlInfoService {
    @Autowired
    private DateProcessingService dateProcessingService;

    private final UrlInfoRepo urlInfoRepo;

    @Override
    public void syncUrlInfo(UrlInfoRequest urlInfoRequest) throws Exception {
        try {
            String currentDate = dateProcessingService.getCurrentDate();
            UrlInfo urlInfo = UrlInfo.builder()
                    .url(urlInfoRequest.getUrl())
                    .startInfo(urlInfoRequest.getStartInfo())
                    .endInfo(urlInfoRequest.getEndInfo())
                    .priority(urlInfoRequest.getPriority())
                    .syncDate(currentDate)
                    .build();
            urlInfoRepo.insert(urlInfo);
        } catch (Exception e) {
            throw new Exception("Error Syncing URL Info");
        }
    }
}
