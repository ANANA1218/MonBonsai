package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;


import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiEntity;

import java.util.Date;
import java.util.List;

public class Bonsai extends BonsaiEntity {

    public String id;
    public String name;
    public String species;
    public Date acquisition_Date;
    public int acquisition_Age;
    public Date last_watering;
    public Date last_repotting;
    public Date last_pruning;
    public String status;

    public Bonsai(String id, String name, String species, Date acsuistion_Date, int acquisition_Age, Date last_watering, Date last_repotting, Date last_pruning, String status) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.acquisition_Date = acsuistion_Date;
        this.acquisition_Age = acquisition_Age;
        this.last_watering = last_watering;
        this.last_repotting = last_repotting;
        this.last_pruning = last_pruning;
        this.status = status;
    }

    public Bonsai() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getAcquisition_Date() {
        return acquisition_Date;
    }

    public void setAcquisition_Date(Date acquisition_Date) {
        this.acquisition_Date = acquisition_Date;
    }

    public int getAcquisition_Age() {
        return acquisition_Age;
    }

    public void setAcquisition_Age(int acquisition_Age) {
        this.acquisition_Age = acquisition_Age;
    }

    public Date getLast_watering() {
        return last_watering;
    }

    public void setLast_watering(Date last_watering) {
        this.last_watering = last_watering;
    }

    public Date getLast_repotting() {
        return last_repotting;
    }

    public void setLast_repotting(Date last_repotting) {
        this.last_repotting = last_repotting;
    }

    public Date getLast_pruning() {
        return last_pruning;
    }

    public void setLast_pruning(Date last_pruning) {
        this.last_pruning = last_pruning;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
