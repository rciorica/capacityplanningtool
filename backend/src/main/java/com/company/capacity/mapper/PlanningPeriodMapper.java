package com.company.capacity.mapper;

import com.company.capacity.dto.request.PlanningPeriodRequest;
import com.company.capacity.dto.response.PlanningPeriodResponse;
import com.company.capacity.model.PlanningPeriod;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanningPeriodMapper {

    PlanningPeriod toEntity(PlanningPeriodRequest request);

    PlanningPeriodResponse toResponse(PlanningPeriod period);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PlanningPeriodRequest request, @MappingTarget PlanningPeriod period);
}
