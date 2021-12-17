package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;

import java.util.Date;
import java.util.UUID;

public class Watering {
    private UUID id;
    private Date watering_date;
    private Bonsai bonsai;
    private Owner owner;

    public Watering() {
    }

    public Watering(UUID id, Date watering_date, Bonsai bonsai, Owner owner) {
        this.id = id;
        this.watering_date = watering_date;
        this.bonsai = bonsai;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getWatering_date() {
        return watering_date;
    }

    public void setWatering_date(Date watering_date) {
        this.watering_date = watering_date;
    }

    public Bonsai getBonsai() {
        return bonsai;
    }

    public void setBonsai(Bonsai bonsai) {
        this.bonsai = bonsai;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}