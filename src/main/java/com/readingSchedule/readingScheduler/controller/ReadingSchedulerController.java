package com.readingSchedule.readingScheduler.controller;

import com.readingSchedule.readingScheduler.request.UrlInfoRequest;
import com.readingSchedule.readingScheduler.response.MessageResponse;
import com.readingSchedule.readingScheduler.service.SyncUrlInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/rss")
public class ReadingSchedulerController {
    @Autowired
    private SyncUrlInfoService syncUrlInfoService;

    @PostMapping(value = "/syncUrlInfo")
    public MessageResponse syncUrlInfo(@RequestBody UrlInfoRequest urlInfoRequest) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            log.info("Request for syncing URL info : {}", urlInfoRequest);
            syncUrlInfoService.syncUrlInfo(urlInfoRequest);
            String message = "URL Info Synced Successfully";
            messageResponse.setSuccessMessage(message);
        } catch (Exception e) {
            log.error("Error fetching links for today's reading");
            String message = "Error fetching links for today's reading";
            messageResponse.setExceptionMessage(message);
        }
        return messageResponse;
    }
}
