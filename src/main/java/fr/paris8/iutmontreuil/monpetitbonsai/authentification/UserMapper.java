package fr.paris8.iutmontreuil.monpetitbonsai.authentification;

import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.UserCreationRequest;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition.AuthorityDto;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition.UserDto;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.AuthorityId;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Infrastructure.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserCreationRequest toUserCreationRequest(UserDto userDto) {
        UserCreationRequest userCreationRequest = new UserCreationRequest();
        userCreationRequest.setUsername(userDto.getUsername());
        return userCreationRequest;
    }

    public static UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setEnabled(userEntity.isEnabled());
        userDto.setAuthorities(userEntity.getAuthorities().stream().map(UserMapper::toAuthorityDto).collect(Collectors.toList()));
        return userDto;
    }

    public static AuthorityDto toAuthorityDto(AuthorityEntity authorityEntity) {
        AuthorityDto authorityDto = new AuthorityDto();
        authorityDto.setId(authorityEntity.getAuthorityId().getUuid());
        authorityDto.setAuthority(authorityEntity.getAuthority());
        return authorityDto;
    }

    public static AuthorityEntity toAuthorityEntity(AuthorityDto authorityDto) {
        AuthorityEntity authorityEntity = new AuthorityEntity();
        AuthorityId authorityId = new AuthorityId();
        authorityId.setUuid(authorityDto.getId());
        authorityId.setAuthority(authorityDto.getAuthority());
        return authorityEntity;
    }
}