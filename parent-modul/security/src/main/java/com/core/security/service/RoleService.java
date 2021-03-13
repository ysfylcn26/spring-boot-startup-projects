package com.core.security.service;

import com.core.basic.utils.UtilMethods;
import com.core.model.models.entity.Role;
import com.core.model.models.enums.RoleType;
import com.core.model.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Set<RoleType> getRoleList(UserDetails userDetails){
        return userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).map(RoleType::decode).collect(Collectors.toSet());
    }


    public Set<Role> getRoles(Set<RoleType> roleTypes){
        return roleRepository.findAllByRoleNameIn(RoleType.roleTypeWithoutAnonymous(roleTypes)).orElse(new HashSet<>());
    }
}
