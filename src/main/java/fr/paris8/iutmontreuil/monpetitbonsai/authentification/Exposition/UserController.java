package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition;


import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.*;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
  //  @PreAuthorize("hasAuthority('ADMIN')")
   // @PreAuthorize("hasAuthority('STAFF')")
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


    @GetMapping("/me")
    public ResponseEntity<UserDto> getMe(){
        return userService.getMe().map(UserMapper::userToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




}



