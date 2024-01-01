package com.wizzer.challenge.adapters.jdbcrepository.person;

import com.wizzer.challenge.adapters.jdbcrepository.person.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonJpaRepository extends CrudRepository<PersonEntity, String> {
}
