package fr.paris8.iutmontreuil.monpetitbonsai.authentification.Domaine;

public class UserCreationRequest {
    private String username;
    private String password;

    public UserCreationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}