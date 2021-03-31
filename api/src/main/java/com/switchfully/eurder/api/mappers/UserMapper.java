package com.switchfully.eurder.api.mappers;

import com.switchfully.eurder.api.dtos.users.CreateDtoUser;
import com.switchfully.eurder.api.dtos.users.DtoUser;
import com.switchfully.eurder.domain.elements.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);

    public DtoUser changeUserToDtoUser(User user){
        LOGGER.info("Returning a DtoUser based on User with id " + user.getId());
        return new DtoUser().
                setId(user.getId()).
                setEmail(user.getEmail()).
                setFirstName(user.getFirstName()).
                setLastName(user.getLastName()).
                setRole(user.getRole());
    }

    public User changeDtoUserToUser(CreateDtoUser createdDtoUser){
        LOGGER.info("Returning a User based on a DtoUser");
        return new User(createdDtoUser.getFirstName(), createdDtoUser.getLastName(), createdDtoUser.getEmail(), createdDtoUser.getRole());
    }

    public List<DtoUser> changeCollectionOfUsersToListOfDtoUsers(Collection<User> usersToChange){
        LOGGER.info("Returning all Users in the form of DtoUsers");
        return usersToChange.stream().map(user -> changeUserToDtoUser(user)).collect(Collectors.toList());
    }
}
