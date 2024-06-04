package com.readingSchedule.readingScheduler.response;

import com.readingSchedule.readingScheduler.request.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadsInfo {
    private String url;
    private PageInfo startInfo;
    private PageInfo endInfo;
}
