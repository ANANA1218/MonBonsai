package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.*;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.*;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.BonsaiEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.PruningEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.RepottingEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.WateringEntity;


public class BonsaiMapper {


    public static Bonsai DtoToBonsai (BonsaiDTO bonsaiDTO){
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiDTO.getId());
        bonsai.setName(bonsaiDTO.getName());
        bonsai.setSpecies(bonsaiDTO.getSpecies());
        bonsai.setAcquisition_date(bonsaiDTO.getAcquisition_date());
        bonsai.setAcquisition_age(bonsaiDTO.getAcquisition_age());
        bonsai.setStatus(bonsaiDTO.getStatus());
        return bonsai;
    }
    public static BonsaiDTO bonsaiToDto (Bonsai bonsai){
        BonsaiDTO bonsaiDTO = new BonsaiDTO();
        bonsaiDTO.setId(bonsai.getId());
        bonsaiDTO.setName(bonsai.getName());
        bonsaiDTO.setSpecies(bonsai.getSpecies());
        bonsaiDTO.setAcquisition_date(bonsai.getAcquisition_date());
        bonsaiDTO.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiDTO.setStatus(bonsai.getStatus());
        return bonsaiDTO;
    }
    public static Bonsai EntityToBonsai(BonsaiEntity bonsaiEntity){
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiEntity.getId());
        bonsai.setName(bonsaiEntity.getName());
        bonsai.setSpecies(bonsaiEntity.getSpecies());
        bonsai.setAcquisition_date(bonsaiEntity.getAcquisition_date());
        bonsai.setAcquisition_age(bonsaiEntity.getAcquisition_age());
        bonsai.setStatus(bonsaiEntity.getStatus());
        return bonsai;
    }
    public static BonsaiEntity BonsaiToEntity (Bonsai bonsai){
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsai.setId(bonsai.getId());
        bonsai.setName(bonsai.getName());
        bonsai.setSpecies(bonsai.getSpecies());
        bonsai.setAcquisition_date(bonsai.getAcquisition_date());
        bonsai.setAcquisition_age(bonsai.getAcquisition_age());
        bonsai.setStatus(bonsai.getStatus());

        return bonsaiEntity;
    }

    public static Watering EntityToWatering(WateringEntity wateringEntity) {
        Watering watering = new Watering();
        watering.setId(wateringEntity.getId());
        watering.setWatering_date(wateringEntity.getWatering_date());
        watering.setBonsai(BonsaiMapper.EntityToBonsai(wateringEntity.getBonsai()));
        return watering;
    }

    public static WateringDTO wateringToDto (Watering watering) {
        WateringDTO wateringDTO = new WateringDTO();
        wateringDTO.setId(watering.getId());
        wateringDTO.setWatering_date(watering.getWatering_date());
        return wateringDTO;
    }


    public static Repotting EntityToRepotting(RepottingEntity repottingEntity) {
        Repotting repotting = new Repotting();
        repotting.setId(repottingEntity.getId());
        repotting.setRepotting_date(repottingEntity.getRepotting_date());
        repotting.setBonsai(BonsaiMapper.EntityToBonsai(repottingEntity.getBonsai()));
        return repotting;
    }

    public static RepottingDTO  RepottingToDto(Repotting repotting) {
        RepottingDTO repottingDTO = new RepottingDTO();
        repottingDTO.setId(repotting.getId());
        repottingDTO.setRepotting_date(repotting.getRepotting_date());
        return repottingDTO;
    }

    public static Pruning EntityToPruning(PruningEntity pruningEntity) {
        Pruning pruning = new Pruning();
        pruning.setId(pruningEntity.getId());
        pruning.setPruning_date(pruningEntity.getPruning_date());
        pruning.setBonsai(BonsaiMapper.EntityToBonsai(pruningEntity.getBonsai()));
        return pruning;
    }

    public static PruningDTO PruningtoDto(Pruning pruning) {
        PruningDTO pruningDTO = new PruningDTO();
        pruningDTO.setId(pruning.getId());
        pruningDTO.setPruning_date(pruning.getPruning_date());
        return pruningDTO;
    }



    }


