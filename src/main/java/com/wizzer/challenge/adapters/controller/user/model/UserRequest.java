package com.wizzer.challenge.adapters.controller.user.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequest {
    @NotEmpty(message = "Must include your id")
    @NotNull(message = "Must include your id")
    String id;

    @NotEmpty(message = "Must include your email")
    @NotNull(message = "Must include your email")
    String email;

    Boolean enabled;
}
