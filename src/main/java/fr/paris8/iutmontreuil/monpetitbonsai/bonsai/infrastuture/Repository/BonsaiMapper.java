package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.BonsaiDTO;


public class BonsaiMapper {




    public static BonsaiEntity BonsaiToEntity(Bonsai bonsai){

        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsai.getId());
        bonsaiConverted.setName(bonsai.getName());




        return bonsaiConverted;
    }

    public static Bonsai EntityToBonsai(BonsaiEntity bonsaiEntity){

        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsaiEntity.getId());
        bonsaiConverted.setName(bonsaiEntity.getName());




        return bonsaiConverted;
    }



    public static Bonsai BonsaiToDTO(Bonsai bonsai){

        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsai.getId());
        bonsaiConverted.setName(bonsai.getName());
        bonsaiConverted.setSpecies(bonsai.getSpecies());
        bonsaiConverted.setAcquisition_Age(bonsai.getAcquisition_Age());
        bonsaiConverted.setAcquisition_Date(bonsai.getAcquisition_Date());
        bonsaiConverted.setLast_watering(bonsai.getLast_watering());
        bonsaiConverted.setLast_repotting(bonsai.getLast_repotting());
        bonsaiConverted.setLast_pruning(bonsai.getLast_pruning());
        bonsaiConverted.setStatus(bonsai.getStatus());

        return bonsaiConverted;
    }

    public static Bonsai DTOToBonsai(BonsaiDTO bonsaiDTO){

        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsaiDTO.getId());
        bonsaiConverted.setName(bonsaiDTO.getName());
        bonsaiConverted.setSpecies(bonsaiDTO.getSpecies());
        bonsaiConverted.setAcquisition_Age(bonsaiDTO.getAcquisition_Age());
        bonsaiConverted.setAcquisition_Date(bonsaiDTO.getAcquisition_Date());
        bonsaiConverted.setLast_watering(bonsaiDTO.getLast_watering());
        bonsaiConverted.setLast_repotting(bonsaiDTO.getLast_repotting());
        bonsaiConverted.setLast_pruning(bonsaiDTO.getLast_pruning());
        bonsaiConverted.setStatus(bonsaiDTO.getStatus());


        return bonsaiConverted;
    }



}
