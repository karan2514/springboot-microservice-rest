package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.DTO.UserDTO;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.AutoUserMapper;
import net.javaguides.springboot.mapper.userMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        //convert UserDto into user JPA Entity

        //User user = userMapper.maptoUser(userDTO);
        //User user = modelMapper.map(userDTO, User.class);

         User user = AutoUserMapper.MAPPER.mapToUser(userDTO);
        User savedUser = userRepository.save(user);


        // convert user jpa entity to userDTO

        //UserDTO savedUserDTO = userMapper.mapToUserDTO(savedUser);
       // UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);
        UserDTO savedUserDTO = AutoUserMapper.MAPPER.mapToUserDTO(savedUser);
        return savedUserDTO;

    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();
        //return userMapper.mapToUserDTO(user);
       // return modelMapper.map(user,UserDTO.class);
        return AutoUserMapper.MAPPER.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();

        //return allUsers.stream().map(userMapper::mapToUserDTO).collect(Collectors.toList());
        //return allUsers.stream().map((user)->modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
        return allUsers.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        //userRepository.save(existingUser);
        //return userMapper.mapToUserDTO(updatedUser);
        //return modelMapper.map(updatedUser,UserDTO.class);
        return AutoUserMapper.MAPPER.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteuser(Long Id) {
        userRepository.deleteById(Id);
        //return "User Deleted successfully";
    }
}
