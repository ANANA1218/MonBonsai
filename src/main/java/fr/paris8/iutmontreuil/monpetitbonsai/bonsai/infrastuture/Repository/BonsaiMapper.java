package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.BonsaiDTO;


public class BonsaiMapper {


    public static Bonsai DtoToBonsai (BonsaiDTO bonsaiDTO){
        Bonsai bonsaiConvert = new Bonsai();
        bonsaiConvert.setId(bonsaiDTO.getId());
        bonsaiConvert.setName(bonsaiDTO.getName());
        bonsaiConvert.setSpecies(bonsaiDTO.getSpecies());
        bonsaiConvert.setAcquisition_Date(bonsaiDTO.getAcquisition_Date());
        bonsaiConvert.setAcquisition_Age(bonsaiDTO.getAcquisition_Age());
        bonsaiConvert.setStatus(bonsaiDTO.getStatus());

        return bonsaiConvert;
    }

    public static Bonsai EntityToBonsai(BonsaiEntity bonsaiEntity){
        Bonsai bonsaiConvert = new Bonsai();
        bonsaiConvert.setId(bonsaiEntity.getId());
        bonsaiConvert.setName(bonsaiEntity.getName());
        bonsaiConvert.setSpecies(bonsaiEntity.getSpecies());
        bonsaiConvert.setAcquisition_Date(bonsaiEntity.getAcquisition_date());
        bonsaiConvert.setAcquisition_Age(bonsaiEntity.getAcquisition_age());
        bonsaiConvert.setStatus(bonsaiEntity.getStatus());

        return bonsaiConvert;
    }


    public static BonsaiDTO bonsaiToDto (Bonsai bonsai){
        BonsaiDTO bonsaiConvert = new BonsaiDTO();
        bonsaiConvert.setId(bonsai.getId());
        bonsaiConvert.setName(bonsai.getName());
        bonsaiConvert.setSpecies(bonsai.getSpecies());
        bonsaiConvert.setAcquisition_Date(bonsai.getAcquisition_Date());
        bonsaiConvert.setAcquisition_Age(bonsai.getAcquisition_Age());
        bonsaiConvert.setStatus(bonsai.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiEntity dtoToEntity (BonsaiDTO bonsaiDto){
        BonsaiEntity bonsaiConvert = new BonsaiEntity();
        bonsaiConvert.setId(bonsaiDto.getId());
        bonsaiConvert.setName(bonsaiDto.getName());
        bonsaiConvert.setSpecies(bonsaiDto.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsaiDto.getAcquisition_Date());
        bonsaiConvert.setAcquisition_age(bonsaiDto.getAcquisition_Age());
        bonsaiConvert.setStatus(bonsaiDto.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiEntity BonsaiToEntity (Bonsai bonsai){
        BonsaiEntity bonsaiConvert = new BonsaiEntity();
        bonsaiConvert.setId(bonsai.getId());
        bonsaiConvert.setName(bonsai.getName());
        bonsaiConvert.setSpecies(bonsai.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsai.getAcquisition_Date());
        bonsaiConvert.setAcquisition_age(bonsai.getAcquisition_Age());
        bonsaiConvert.setStatus(bonsai.getStatus());


        return bonsaiConvert;
    }


}