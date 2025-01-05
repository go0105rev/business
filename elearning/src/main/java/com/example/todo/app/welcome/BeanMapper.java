package com.example.todo.app.welcome;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.example.todo.app.mapper.UserForm;
import com.example.todo.domain.model.UserInf;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BeanMapper {

    UserInf map(UserForm user);
}
