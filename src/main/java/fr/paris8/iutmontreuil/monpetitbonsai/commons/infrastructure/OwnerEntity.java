package fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "owner")
@Table(name = "users")
public class OwnerEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    @Column(name = "username")
    private String name;
    @OneToMany (targetEntity = BonsaiEntity.class, mappedBy = "ownerEntity")
    private List<BonsaiEntity> Bonsai ;




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

    public List<BonsaiEntity> getBonsai() {
        return Bonsai;
    }

    public void setBonsai(List<BonsaiEntity> bonsai) {
        Bonsai = bonsai;
    }
}
