package com.core.security.service;

import com.core.basic.exception.ResourceNotFoundException;
import com.core.basic.utils.ErrorMessages;
import com.core.model.models.entity.User;
import com.core.model.repository.UserRespository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;

    @Transactional(readOnly = true)
    public User getUserByUserName(@NonNull String userName){
        return userRespository.findByUserNameWithRoles(userName)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.USER_NOT_FOUND));
    }
}
