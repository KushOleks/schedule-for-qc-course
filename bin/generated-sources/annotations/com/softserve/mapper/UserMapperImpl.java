package com.softserve.mapper;

import com.softserve.dto.RegistrationRequestDTO;
import com.softserve.dto.UserCreateDTO;
import com.softserve.dto.UserDTO;
import com.softserve.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( user.getEmail() );
        userDTO.setId( user.getId() );
        userDTO.setRole( user.getRole() );

        return userDTO;
    }

    @Override
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDTO.getEmail() );
        user.setId( userDTO.getId() );
        user.setRole( userDTO.getRole() );

        return user;
    }

    @Override
    public User toCreateUser(RegistrationRequestDTO registrationDTO) {
        if ( registrationDTO == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( registrationDTO.getEmail() );
        user.setPassword( registrationDTO.getPassword() );

        return user;
    }

    @Override
    public List<UserDTO> toUserDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    @Override
    public User toUser(UserCreateDTO userCreateDTO) {
        if ( userCreateDTO == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userCreateDTO.getEmail() );
        user.setId( userCreateDTO.getId() );
        user.setPassword( userCreateDTO.getPassword() );

        return user;
    }

    @Override
    public UserCreateDTO toUserCreateDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserCreateDTO userCreateDTO = new UserCreateDTO();

        userCreateDTO.setEmail( user.getEmail() );
        userCreateDTO.setId( user.getId() );
        userCreateDTO.setPassword( user.getPassword() );

        return userCreateDTO;
    }
}
