package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;


import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Bonsai {
    private UUID id;
    private String name;
    private String species;
    private Date acquisition_date;
    private int acquisition_age;
    private String status;
    private List<Watering> watering;
    private List<Repotting> repotting;
    private List<Pruning> pruning;
    private List<fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner> Owner;


    public Bonsai() {}

    public Bonsai(UUID id, String name, String species, Date acquisition_date, int acquisition_age, String status, List<Watering> watering, List<Repotting> repotting, List<Pruning> pruning, List<fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner> owner) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
        this.status = status;
        this.watering = watering;
        this.repotting = repotting;
        this.pruning = pruning;
        Owner = owner;
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

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Watering> getWatering() {
        return watering;
    }

    public void setWatering(List<Watering> watering) {
        this.watering = watering;
    }

    public List<Repotting> getRepotting() {
        return repotting;
    }

    public void setRepotting(List<Repotting> repotting) {
        this.repotting = repotting;
    }

    public List<Pruning> getPruning() {
        return pruning;
    }

    public void setPruning(List<Pruning> pruning) {
        this.pruning = pruning;
    }

    public List<fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner> getOwner() {
        return Owner;
    }

    public void setOwner(List<fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner> owner) {
        Owner = owner;
    }
}