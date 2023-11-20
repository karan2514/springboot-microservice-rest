package net.javaguides.springboot.service;

import net.javaguides.springboot.DTO.UserDTO;


import java.util.List;

public interface UserService {

    UserDTO createUser (UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteuser(Long Id);
}
