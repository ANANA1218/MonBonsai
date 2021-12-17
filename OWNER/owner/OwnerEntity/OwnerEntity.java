package fr.paris8.iutmontreuil.monpetitbonsai.owner.OwnerEntity;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.BonsaiEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "owner")
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @ManyToOne(targetEntity = BonsaiEntity.class) @JoinColumn(name = "bonsai_id")
    private BonsaiEntity bonsai;




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


    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}