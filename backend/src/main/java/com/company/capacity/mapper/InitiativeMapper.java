package com.company.capacity.mapper;

import com.company.capacity.dto.request.InitiativeRequest;
import com.company.capacity.dto.response.InitiativeResponse;
import com.company.capacity.model.Initiative;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InitiativeMapper {

    Initiative toEntity(InitiativeRequest request);

    InitiativeResponse toResponse(Initiative initiative, long epicCount, long completedEpicCount);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(InitiativeRequest request, @MappingTarget Initiative initiative);
}
