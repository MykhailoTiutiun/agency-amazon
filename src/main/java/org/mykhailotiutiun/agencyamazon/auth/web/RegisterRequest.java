package org.mykhailotiutiun.agencyamazon.auth.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {}
