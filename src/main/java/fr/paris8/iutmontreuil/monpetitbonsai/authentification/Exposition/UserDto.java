package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Exposition;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String username;
    private boolean enabled;
    private List<AuthorityDto> authorities;

    public UserDto() {
        this.authorities = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AuthorityDto> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityDto> authorities) {
        this.authorities = authorities;
    }
}