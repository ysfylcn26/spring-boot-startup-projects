package com.core.model.models.entity;

import com.core.model.models.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Immutable
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_sequence")
    @SequenceGenerator(name = "roles_id_sequence", sequenceName = "roles_id_sequence", allocationSize = 4)
    private long id;
    @Enumerated(EnumType.STRING)
    private RoleType roleName;
}
