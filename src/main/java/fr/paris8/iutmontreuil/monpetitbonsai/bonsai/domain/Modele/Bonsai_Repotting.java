package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name= "Bonsai_Repotting ")
@Table(name ="Bonsai_Repotting ")
public class Bonsai_Repotting {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")



        @Column(name = "id")
        private String id;

        @Column(name = "date")
        private Timestamp dateTime;

        @Column(name = "bonsai_id")
        private String bonsai_id;


        public  Bonsai_Repotting (String id, Timestamp dateTime, String bonsai_id) {
            this.id = id;
            this.dateTime = dateTime;
            this.bonsai_id = bonsai_id;
        }


        public String getId() {
            return id;
        }

        public Timestamp getDateTime() {
            return dateTime;
        }

        public String getBonsai_id() {
            return bonsai_id;
        }


        public void setId(String id) {
            this.id = id;
        }

        public void setDateTime(Timestamp dateTime) {
            this.dateTime = dateTime;
        }

        public void setBonsai_id(String bonsai_id) {
            this.bonsai_id = bonsai_id;
        }

    }





