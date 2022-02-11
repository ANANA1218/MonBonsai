package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition;


import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.ChangePasswordRequest;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.ChangeUserAuthorityRequest;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.UserCreationRequest;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.UserService;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDto> findAll() {

        return userService.findAll()
                .stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create (@RequestBody UserCreationRequest createRequest){

        userService.create(createRequest);
    }

    @PutMapping("/me/password")
    public void changeMyPassword(@RequestBody ChangePasswordRequest changePasswordRequest){

        userService.changeMyPassword(changePasswordRequest);

    }

    @PutMapping("/users/{uuid}/authority")
    public void changeUserAuthority(@PathVariable UUID uuid, @RequestBody ChangeUserAuthorityRequest changeUserAuthorityRequest){

        userService.changeUserAuthority(uuid, changeUserAuthorityRequest);
    }



    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser (@RequestBody UserDto userDto){

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/owners")
    public List<OwnerDTO> getOwners (@RequestBody OwnerDTO ownerDTO){

        return userService.getOwners()
                .stream()
                .map(OwnerMapper::OwnertoDto)
                .collect(Collectors.toList());
    }

}



