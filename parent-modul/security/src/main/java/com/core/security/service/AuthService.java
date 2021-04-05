package com.core.security.service;

import com.core.basic.exception.ResourceAlreadyExists;
import com.core.basic.utils.ErrorMessages;
import com.core.basic.utils.ResponseMessages;
import com.core.basic.utils.UtilMethods;
import com.core.model.dto.request.AuthenticationRequest;
import com.core.model.dto.request.SignUpRequest;
import com.core.model.dto.response.AuthenticationResponse;
import com.core.model.dto.response.GenericReturnValue;
import com.core.model.models.entity.User;
import com.core.model.models.enums.RoleType;
import com.core.model.models.enums.UserStatus;
import com.core.model.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateAccessToken(authentication);
        Set<RoleType> roleList = authentication.getAuthorities().stream().map(x -> RoleType.valueOf(x.getAuthority()))
                .collect(Collectors.toSet());
        return AuthenticationResponse.builder().token(jwt).roleList(roleList).username(request.getUsername()).build();
    }

    @Transactional
    public GenericReturnValue<String> signUp(SignUpRequest signUpRequest) {
        log.info("There is this user");
        if (userRespository.existsByUsername(signUpRequest.getUsername()))
            throw new ResourceAlreadyExists(ErrorMessages.USERNAME_ALREADY_EXIST);
        if (!UtilMethods.isNullOrBlankCheck(signUpRequest.getEmail())
                && userRespository.existsByEmail(signUpRequest.getEmail()))
            throw new ResourceAlreadyExists(ErrorMessages.EMAIL_ALREADY_EXIST);
        User user = User.builder().username(signUpRequest.getUsername()).email(signUpRequest.getEmail())
                .firstName(signUpRequest.getFirstName()).surname(signUpRequest.getSurname()).userUuid(UUID.randomUUID())
                .status(UserStatus.ACTIVE).password(passwordEncoder.encode(signUpRequest.getPassword())).build();
        user.setRoles(roleService.getRoles(signUpRequest.getRoleType()));
        userRespository.save(user);
        return new GenericReturnValue<>(ResponseMessages.SIGNUP_SUCCESS_USER);
    }

}
