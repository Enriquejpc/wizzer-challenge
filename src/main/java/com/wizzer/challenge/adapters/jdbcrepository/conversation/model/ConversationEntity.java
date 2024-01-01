package com.wizzer.challenge.adapters.jdbcrepository.conversation.model;

import com.wizzer.challenge.adapters.jdbcrepository.PersonConversationEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "CONVERSATION")
public class ConversationEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "enabled", nullable = false)
    private Boolean isEnabled;

    @Column(name = "con_category_id", nullable = false)
    private Integer categoryFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "con_category_id", insertable = false, updatable = false)
    private ConversationCategoryType conversationCategoryType;

    @OneToMany(mappedBy = "conversationEntity", cascade = CascadeType.ALL)
    private List<PersonConversationEntity> personConversationEntityList;

}
