package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // MapStruct sẽ tự map field trùng tên
    UserDto toDto(User entity);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto dto);

    // mapping cho List
    List<UserDto> toDto(List<User> entities);
    List<User> toEntity(List<UserDto> dtos);
}
