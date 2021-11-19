package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name= "Bonsai")
@Table(name ="bonsai")
public class BonsaiEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    public BonsaiEntity() {

    }

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
}
