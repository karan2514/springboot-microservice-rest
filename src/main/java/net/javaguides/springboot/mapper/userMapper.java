package net.javaguides.springboot.mapper;

import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;

import java.util.List;

public class userMapper {

    //convert userJPA to UserDTO
    public static UserDTO mapToUserDTO(User user){

        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }


    //convert UserDTO to User
    public static User maptoUser(UserDTO userDTO){

        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
