package com.company.capacity.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {
    private long teamCount;
    private long personCount;
    private long initiativeCount;
    private long epicCount;
    private long completedEpicCount;
}
