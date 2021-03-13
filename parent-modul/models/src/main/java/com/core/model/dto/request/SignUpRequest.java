package com.core.model.dto.request;

import com.core.model.models.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(min = 6, max = 25)
    private String username;
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    private Set<RoleType> roleType;
    private String firstName;
    private String surname;
    @Email
    private String email;

}
