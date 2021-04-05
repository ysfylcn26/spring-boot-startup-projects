package com.core.security.service;

import com.core.basic.exception.UnauthorizedException;
import com.core.basic.utils.ErrorMessages;
import com.core.model.models.entity.User;
import com.core.model.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRespository userRespository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRespository.findByUserNameWithRoles(s)
                .orElseThrow(() -> new UnauthorizedException(ErrorMessages.UNAUTHORIZED_USER));
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().getRole())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                simpleGrantedAuthorities);
    }

}
