package com.wizzer.challenge.domain;

import com.wizzer.challenge.adapters.jdbcrepository.person.model.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    PersonEntity toDTO(User user);
    User toDomain(PersonEntity user);
}
