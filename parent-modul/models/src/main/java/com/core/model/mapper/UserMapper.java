package com.core.model.mapper;

import com.core.model.dto.UserDto;
import com.core.model.models.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userMapper(User user);
}
