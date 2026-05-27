package com.company.capacity.mapper;

import com.company.capacity.dto.request.EpicRequest;
import com.company.capacity.dto.response.EpicResponse;
import com.company.capacity.model.Epic;
import com.company.capacity.model.Initiative;
import com.company.capacity.model.Team;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EpicMapper {

    // CREATE
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)

    // mapăm explicit câmpurile din request
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "estimatedDays", source = "request.estimatedDays")
    @Mapping(target = "dueDate", source = "request.dueDate")
    @Mapping(target = "status", source = "request.status")
    @Mapping(target = "confidence", source = "request.confidence")

    // mapăm explicit relațiile
    @Mapping(target = "team", source = "team")
    @Mapping(target = "initiative", source = "initiative")
    Epic toEntity(EpicRequest request, Team team, Initiative initiative);

    // UPDATE
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)

    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "estimatedDays", source = "request.estimatedDays")
    @Mapping(target = "dueDate", source = "request.dueDate")
    @Mapping(target = "status", source = "request.status")
    @Mapping(target = "confidence", source = "request.confidence")

    @Mapping(target = "team", source = "team")
    @Mapping(target = "initiative", source = "initiative")
    void updateEntity(EpicRequest request, @MappingTarget Epic epic, Team team, Initiative initiative);

    // RESPONSE
    @Mapping(target = "initiativeId", source = "initiative.id")
    @Mapping(target = "initiativeName", source = "initiative.name")
    @Mapping(target = "teamId", source = "team.id")
    @Mapping(target = "teamName", source = "team.name")
    EpicResponse toResponse(Epic epic);
}
