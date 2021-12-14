package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import java.util.Date;
import java.util.UUID;

public class Pruning {
    private UUID id;
    private Date pruning_date;
    private Bonsai bonsai;



    public Pruning() {
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
}