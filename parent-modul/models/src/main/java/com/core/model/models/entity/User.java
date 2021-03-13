package com.core.model.models.entity;

import com.core.model.models.audit.Auditable;
import com.core.model.models.enums.UserStatus;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_sequence")
    @SequenceGenerator(name = "users_id_sequence", sequenceName = "users_id_sequence", allocationSize = 20)
    private Long id;
    private UUID userUuid;
    @Length(min = 6, max = 25)
    private String username;
    @Email
    @Length(min = 6, max = 100)
    private String email;
    @Length(max = 100)
    private String firstName;
    @Length(max = 100)
    private String surname;
    @NotBlank
    @Length(max = 255)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    @BatchSize(size = 3)
    private Set<Role> roles = new HashSet<>();
}
