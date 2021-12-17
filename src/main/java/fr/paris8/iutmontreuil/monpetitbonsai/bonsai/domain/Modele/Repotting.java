package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;

import java.util.Date;
import java.util.UUID;

public class Repotting {
    private UUID id;
    private Date repotting_date;
    private Bonsai bonsai;
    private Owner owner;

    public Repotting() {
    }


    public Repotting(UUID id, Date repotting_date, Bonsai bonsai, Owner owner) {
        this.id = id;
        this.repotting_date = repotting_date;
        this.bonsai = bonsai;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getRepotting_date() {
        return repotting_date;
    }

    public void setRepotting_date(Date repotting_date) {
        this.repotting_date = repotting_date;
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