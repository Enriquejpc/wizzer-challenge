package com.wizzer.challenge.businesscore.interfaces.user;

import com.wizzer.challenge.domain.User;

import java.util.List;

public interface UserQuery {
    User getById(String userId);
    List<User> getAll();
}
