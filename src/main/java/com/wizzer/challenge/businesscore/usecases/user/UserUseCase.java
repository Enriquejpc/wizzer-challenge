package com.wizzer.challenge.businesscore.usecases.user;

import com.wizzer.challenge.adapters.jdbcrepository.JdbcPersonConversationAdapter;
import com.wizzer.challenge.adapters.jdbcrepository.person.JdbcPersonAdapter;
import com.wizzer.challenge.businesscore.exceptions.BusinessException;
import com.wizzer.challenge.businesscore.interfaces.user.UserCommand;
import com.wizzer.challenge.businesscore.interfaces.user.UserQuery;
import com.wizzer.challenge.businesscore.usecases.DomainService;
import com.wizzer.challenge.config.ErrorCode;
import com.wizzer.challenge.domain.User;
import com.wizzer.challenge.domain.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserUseCase implements UserCommand, UserQuery {
    private final JdbcPersonAdapter jdbcPersonAdapter;

    private final JdbcPersonConversationAdapter jdbcPersonConversationAdapter;

    private final DomainService domainService;

    public UserUseCase(JdbcPersonAdapter jdbcPersonAdapter, JdbcPersonConversationAdapter jdbcPersonConversationAdapter, DomainService domainService) {
        this.jdbcPersonAdapter = jdbcPersonAdapter;
        this.jdbcPersonConversationAdapter = jdbcPersonConversationAdapter;
        this.domainService = domainService;
    }

    @Override
    public User create(User user) {
        if(domainService.checkUser(user.getId())!= null) {
            throw new BusinessException(ErrorCode.RESOURCE_DUPLICATE_ERROR);
        }
        return UserMapper.INSTANCE.toDomain(jdbcPersonAdapter.createOrUpdate(user.withIsEnabled(true)));
    }

    @Override
    public User update(User user) {
        return UserMapper.INSTANCE.toDomain(jdbcPersonAdapter.createOrUpdate(user));
    }

    @Override
    public void delete(String userId) {
        jdbcPersonAdapter.delete(userId);
    }

    @Override
    public Integer joinToConversation(String userId, Integer conversation) {
        return  jdbcPersonConversationAdapter.joinUserToConversation(userId, conversation).getId();
    }

    @Override
    public User getById(String userId) {
        return domainService.checkUser(userId);
    }

    @Override
    public List<User> getAll() {
        return jdbcPersonAdapter.getAll().stream()
                .map(UserMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }
}
