package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition;


import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.*;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
     @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDto> findAll() {

        return userService.findAll()
                .stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void create(@RequestBody UserCreationRequest createRequest) {

        userService.create(createRequest);
    }


    @GetMapping("/me")
    public ResponseEntity<UserDto> getMe() {
        return userService.getMe().map(UserMapper::userToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/me/password")
    public ResponseEntity<UserDto> updatePassword(@RequestBody String newPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof AppUser) {
            AppUser credentials = (AppUser) authentication.getPrincipal();
            if (credentials != null) {
                return userService.updatePassword(credentials.getId(), newPassword)
                        .map(UserMapper::toUserDto)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}/authority")
    public ResponseEntity<User> updateAuthority(@PathVariable UUID id, @RequestBody String Authority) {
        userService.updateAuthority(id, Authority);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable UUID uuid) {
        userService.deleteById(uuid);
    }

}



