package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import java.util.Date;
import java.util.UUID;

public class Repotting {
    private UUID id;
    private Date repotting_date;
    private Bonsai bonsai;


    public Repotting() {
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
}