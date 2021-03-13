package com.core.model.dto.response;

import com.core.model.models.enums.RoleType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String username;
    private UUID userUuid;
    private Set<RoleType> roleList = new HashSet<>();
}
