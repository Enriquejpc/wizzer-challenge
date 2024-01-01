package com.wizzer.challenge.adapters.jdbcrepository.conversation.model;

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
@Entity(name = "CONVERSATION_CATEGORY")
public class ConversationCategoryType {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "enabled", nullable = false)
    private Boolean isEnabled;

    @OneToMany(mappedBy = "conversationCategoryType", cascade = CascadeType.ALL)
    private List<ConversationEntity> conversationEntities;


}
