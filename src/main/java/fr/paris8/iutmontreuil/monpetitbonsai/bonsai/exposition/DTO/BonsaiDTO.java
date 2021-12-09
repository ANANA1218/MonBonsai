package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO;


import java.util.Date;


public class BonsaiDTO {

    public String id;
    public String name;
    public String species;
    public Date acquisition_Date;
    public int acquisition_Age;

    public String status;

    public BonsaiDTO(String id, String name, String species, Date acsuistion_Date, int acquisition_Age, String status) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.acquisition_Date = acsuistion_Date;
        this.acquisition_Age = acquisition_Age;

        this.status = status;
    }

    public BonsaiDTO() {

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getAcquisition_Date() {
        return acquisition_Date;
    }

    public void setAcquisition_Date(Date acquisition_Date) {
        this.acquisition_Date = acquisition_Date;
    }

    public int getAcquisition_Age() {
        return acquisition_Age;
    }

    public void setAcquisition_Age(int acquisition_Age) {
        this.acquisition_Age = acquisition_Age;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
