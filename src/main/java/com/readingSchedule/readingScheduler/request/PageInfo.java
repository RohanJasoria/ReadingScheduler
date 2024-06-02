package com.readingSchedule.readingScheduler.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private Integer pageNumber;
    private String topicName;
}
