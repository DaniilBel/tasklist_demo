package org.project.tasklist_demo.web.mappers;

import org.mapstruct.Mapper;
import org.project.tasklist_demo.domain.user.User;
import org.project.tasklist_demo.web.dto.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
