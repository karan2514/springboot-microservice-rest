package net.javaguides.springboot.mapper;

import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDTO mapToUserDTO(User user);
    User mapToUser(UserDTO userDTO);
}
