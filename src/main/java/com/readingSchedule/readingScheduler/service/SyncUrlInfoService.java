package com.readingSchedule.readingScheduler.service;


import com.readingSchedule.readingScheduler.request.UrlInfoRequest;

public interface SyncUrlInfoService {
    void syncUrlInfo(UrlInfoRequest urlInfoRequest) throws Exception;
}
