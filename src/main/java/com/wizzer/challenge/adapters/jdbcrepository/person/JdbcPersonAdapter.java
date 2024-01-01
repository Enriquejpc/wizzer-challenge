package com.wizzer.challenge.adapters.jdbcrepository.person;

import com.wizzer.challenge.adapters.jdbcrepository.person.model.PersonEntity;
import com.wizzer.challenge.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JdbcPersonAdapter {
    private final PersonJpaRepository jpaRepository;

    public JdbcPersonAdapter(PersonJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Optional<PersonEntity> getById(String id) {
        return jpaRepository.findById(id);
    }

    @Transactional
    public PersonEntity createOrUpdate(User user) {
        return jpaRepository.save(PersonEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .isEnabled(user.getIsEnabled())
                .build());
    }

    @Transactional
    public void delete(String userId) {
        jpaRepository.deleteById(userId);
    }

    public List<PersonEntity> getAll() {
        List<PersonEntity> entities = new ArrayList<>();
        jpaRepository.findAll().iterator().forEachRemaining(entities::add);
        return entities;
    }
}
