package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity(name= "Bonsai_Watering ")
@Table(name ="Bonsai_Watering ")
public class Bonsai_Watering {



    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")


    @Column(name = "id")
    private String id;

    @Column(name = "date")
    private Timestamp dateTime;

    @Column(name = "bonsai_id")
    private String bonsai_id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getBonsai_id() {
        return bonsai_id;
    }

    public void setBonsai_id(String bonsai_id) {
        this.bonsai_id = bonsai_id;
    }

    public Bonsai_Watering(String id, Timestamp dateTime, String bonsai_id) {
        this.id = id;
        this.dateTime = dateTime;
        this.bonsai_id = bonsai_id;






    }
}





