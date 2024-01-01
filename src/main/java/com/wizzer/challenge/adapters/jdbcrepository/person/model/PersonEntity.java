package com.wizzer.challenge.adapters.jdbcrepository.person.model;

import com.wizzer.challenge.adapters.jdbcrepository.PersonConversationEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "PERSON")
public class PersonEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "enabled", nullable = false)
    private Boolean isEnabled;

    @OneToMany(mappedBy = "personEntity", cascade = CascadeType.ALL)
    private List<PersonConversationEntity> personConversationEntityList;
}
