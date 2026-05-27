package com.company.capacity.mapper;

import com.company.capacity.dto.request.TeamRequest;
import com.company.capacity.dto.response.TeamResponse;
import com.company.capacity.model.Team;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    Team toEntity(TeamRequest request);

    TeamResponse toResponse(Team team, int memberCount);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(TeamRequest request, @MappingTarget Team team);
}
