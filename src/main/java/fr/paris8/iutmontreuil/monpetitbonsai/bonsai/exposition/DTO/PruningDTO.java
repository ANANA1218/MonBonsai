package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO;

import java.util.Date;
import java.util.UUID;


public class PruningDTO {

    private UUID id;
    private Date pruning_date;

    public PruningDTO() {
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


}