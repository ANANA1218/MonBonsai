package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;

import java.util.Date;
import java.util.UUID;

public class Pruning {
    private UUID id;
    private Date pruning_date;
    private Bonsai bonsai;
    private Owner owner;



    public Pruning() {
    }


    public Pruning(UUID id, Date pruning_date, Bonsai bonsai, Owner owner) {
        this.id = id;
        this.pruning_date = pruning_date;
        this.bonsai = bonsai;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getPruning_date() {
        return pruning_date;
    }

    public void setPruning_date(Date pruning_date) {
        this.pruning_date = pruning_date;
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