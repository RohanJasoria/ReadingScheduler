package com.readingSchedule.readingScheduler.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlInfoRequest {
    private String url;
    private PageInfo startInfo;
    private PageInfo endInfo;
    private UrlPriority priority;
}
