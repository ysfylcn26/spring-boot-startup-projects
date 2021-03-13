package com.core.model.repository;

import com.core.model.models.entity.Role;
import com.core.model.models.enums.RoleType;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Set<Role>> findAllByRoleNameIn(Set<RoleType> roleTypes);

}
