package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition;

import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.AppUser;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine.UserService;
import fr.paris8.iutmontreuil.monpetitbonsai.authentification.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll().stream()
                .map(UserMapper::UsertoDto)
                .collect(Collectors.toList());
    }










    @PutMapping("/me/password")
    public ResponseEntity<UserDto> updatePassword(@RequestBody String newPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof AppUser) {
            AppUser credentials = (AppUser) authentication.getPrincipal();
            if (credentials != null) {
                return userService.updatePassword(credentials.getId(), newPassword)
                        .map(u -> ResponseEntity.ok(UserMapper.UsertoDto(u)))
                        .orElse(ResponseEntity.notFound().build());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

 //   @PutMapping("/{id}/authority")
   // public ResponseEntity<UserDto> updateAuthority(@PathVariable UUID id, @RequestBody String newAuthority) {

       //     return userService.updateAuthority(id)
                  //  .map(u -> ResponseEntity.ok(UserMapper.toUserDto(u)))
                //    .orElse(ResponseEntity.notFound().build());

//    }


    @GetMapping("/me")
    public ResponseEntity<UserDto> getMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof AppUser) {
            AppUser credentials = (AppUser) authentication.getPrincipal();
            if (credentials != null) {
                Optional<UserDto> user = userService.getById(credentials.getId()).map(UserMapper::UsertoDto);
                if (user.isPresent()) {
                    return ResponseEntity.ok(user.get());
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}