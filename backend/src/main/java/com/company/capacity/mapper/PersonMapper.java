package com.company.capacity.mapper;

import com.company.capacity.dto.request.PersonRequest;
import com.company.capacity.dto.response.PersonResponse;
import com.company.capacity.model.Person;
import com.company.capacity.model.Team;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    @Mapping(target = "team", source = "team")
    Person toEntity(PersonRequest request, Team team);

    @Mapping(target = "teamId", source = "team.id")
    @Mapping(target = "teamName", source = "team.name")
    PersonResponse toResponse(Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "team", source = "team")
    void updateEntity(PersonRequest request, @MappingTarget Person person, Team team);
}
