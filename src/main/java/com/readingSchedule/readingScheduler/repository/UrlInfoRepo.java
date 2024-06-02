package com.readingSchedule.readingScheduler.repository;

import com.readingSchedule.readingScheduler.entity.UrlInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlInfoRepo extends MongoRepository<UrlInfo, String> {
    List<UrlInfo> findBySyncDate(String date);
}
