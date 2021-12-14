package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO;
import java.util.Date;
import java.util.UUID;

public class RepottingDTO {

    private UUID id;
    private Date repotting_date;

    public RepottingDTO() {
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
}