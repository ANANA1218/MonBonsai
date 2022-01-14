package fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO;

import java.util.UUID;

public class BonsaiDTO {
    private UUID id;
    private String name;
    private String species;
    private int acquisition_age;
    private String Status;

    public BonsaiDTO() {
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }
}