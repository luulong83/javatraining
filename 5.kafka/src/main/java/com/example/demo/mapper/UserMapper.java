package com.example.demo.mapper;


import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User entity);

    @Mapping(target = "password", ignore = true) // bỏ qua password khi map
    User toEntity(UserDto dto);

    List<UserDto> toDto(List<User> entities);
    List<User> toEntity(List<UserDto> dtos);
}

