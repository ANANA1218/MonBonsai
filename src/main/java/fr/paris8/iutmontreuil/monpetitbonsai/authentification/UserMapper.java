package fr.paris8.iutmontreuil.monpetitbonsai.authentification;


import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.User;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.UserCreationRequest;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition.AuthorityDto;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition.UserDto;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityId;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    public static User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAuthorities(userDto.getAuthorities().stream().collect(Collectors.toList()));
        return user;
    }

    public static User entityToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        //user.setAuthorities(userEntity.getAuthorities().stream().collect(Collectors.toList()));
        return user;
    }

    public static UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    public static UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setEnabled(userEntity.isEnabled());

        return userDto;

    }

}