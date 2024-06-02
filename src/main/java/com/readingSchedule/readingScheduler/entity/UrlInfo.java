package com.readingSchedule.readingScheduler.entity;

import com.readingSchedule.readingScheduler.request.PageInfo;
import com.readingSchedule.readingScheduler.request.UrlPriority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "url_information")
public class UrlInfo {
    private String url;
    private PageInfo startInfo;
    private PageInfo endInfo;
    private UrlPriority priority;
    private String syncDate;
}
