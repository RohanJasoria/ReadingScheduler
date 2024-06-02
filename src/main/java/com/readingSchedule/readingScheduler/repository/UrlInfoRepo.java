package com.readingSchedule.readingScheduler.repository;

import com.readingSchedule.readingScheduler.entity.UrlInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlInfoRepo extends MongoRepository<UrlInfo, String> {
}
