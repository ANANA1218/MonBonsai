package fr.paris8.iutmontreuil.monpetitbonsai.owner;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Owner {
    private UUID id;
    private String name;
    private List<Bonsai> bonsai = new ArrayList<>();

    public Owner() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bonsai> getBonsai() {
        return bonsai;
    }

    public void setBonsai(List<Bonsai> bonsais) {
        this.bonsai = bonsais;
    }
}