package com.wizzer.challenge.adapters.controller.user;

import com.wizzer.challenge.adapters.controller.PersonConversationRequest;
import com.wizzer.challenge.adapters.controller.user.model.UserRequest;
import com.wizzer.challenge.businesscore.interfaces.conversation.ConversationCommand;
import com.wizzer.challenge.businesscore.interfaces.user.UserCommand;
import com.wizzer.challenge.businesscore.interfaces.user.UserQuery;
import com.wizzer.challenge.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/challenge/user")
public class UserController {

    private final ConversationCommand conversationCommand;
    private final UserCommand userCommand;
    private final UserQuery userQuery;

    public UserController(ConversationCommand conversationCommand, UserCommand userCommand, UserQuery userQuery) {
        this.conversationCommand = conversationCommand;
        this.userCommand = userCommand;
        this.userQuery = userQuery;
    }

    @PostMapping("/add-conversation")
    public ResponseEntity<Integer> addConversation(@RequestBody @Validated PersonConversationRequest body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(conversationCommand.joinUserToConversation(body.getUserId(), body.getConversationId()));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Validated UserRequest body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userCommand.create(User.builder()
                        .id(body.getId())
                        .email(body.getEmail())
                        .isEnabled(true)
                .build()));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody @Validated UserRequest body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userCommand.update(User.builder()
                .id(body.getId())
                .email(body.getEmail())
                .isEnabled(body.getEnabled())
                .build()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(name = "id") String userId) {
        return ResponseEntity.ok().body(userQuery.getById(userId));
    }

    @GetMapping
    public ResponseEntity<List<User>> get() {
        return ResponseEntity.ok().body(userQuery.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") String userId) {
        userCommand.delete(userId);
        return (ResponseEntity<HttpStatus>) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }
}
