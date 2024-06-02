package com.readingSchedule.readingScheduler.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ResponseBody
public class MessageResponse {
    private String successMessage;
    private String exceptionMessage;
}
