package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.*;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.*;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.BonsaiEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.PruningEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.RepottingEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.WateringEntity;


public class BonsaiMapper {


    public static Bonsai DtoToBonsai (BonsaiDTO bonsaiDTO){
        Bonsai bonsaiConvert = new Bonsai();
        bonsaiConvert.setId(bonsaiDTO.getId());
        bonsaiConvert.setName(bonsaiDTO.getName());
        bonsaiConvert.setSpecies(bonsaiDTO.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsaiDTO.getAcquisition_date());
        bonsaiConvert.setAcquisition_age(bonsaiDTO.getAcquisition_age());
        bonsaiConvert.setStatus(bonsaiDTO.getStatus());

        return bonsaiConvert;
    }

    public static Bonsai EntityToBonsai (BonsaiEntity bonsaiEntity){
        Bonsai bonsaiConvert = new Bonsai();
        bonsaiConvert.setId(bonsaiEntity.getId());
        bonsaiConvert.setName(bonsaiEntity.getName());
        bonsaiConvert.setSpecies(bonsaiEntity.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsaiEntity.getAcquisition_date());
        bonsaiConvert.setAcquisition_age(bonsaiEntity.getAcquisition_age());
        bonsaiConvert.setStatus(bonsaiEntity.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiDTO bonsaiToDto (Bonsai bonsai){
        BonsaiDTO bonsaiConvert = new BonsaiDTO();
        bonsaiConvert.setId(bonsai.getId());
        bonsaiConvert.setName(bonsai.getName());
        bonsaiConvert.setSpecies(bonsai.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsai.getAcquisition_date());
        bonsaiConvert.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiConvert.setStatus(bonsai.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiEntity dtoToEntity (BonsaiDTO bonsaiDto){
        BonsaiEntity bonsaiConvert = new BonsaiEntity();
        bonsaiConvert.setId(bonsaiDto.getId());
        bonsaiConvert.setName(bonsaiDto.getName());
        bonsaiConvert.setSpecies(bonsaiDto.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsaiDto.getAcquisition_date());
        bonsaiConvert.setAcquisition_age(bonsaiDto.getAcquisition_age());
        bonsaiConvert.setStatus(bonsaiDto.getStatus());

        return bonsaiConvert;
    }

    public static BonsaiEntity BonsaiToEntity (Bonsai bonsai){
        BonsaiEntity bonsaiConvert = new BonsaiEntity();
        bonsaiConvert.setId(bonsai.getId());
        bonsaiConvert.setName(bonsai.getName());
        bonsaiConvert.setSpecies(bonsai.getSpecies());
        bonsaiConvert.setAcquisition_date(bonsai.getAcquisition_date());
        bonsaiConvert.setAcquisition_age(bonsai.getAcquisition_age());
        bonsaiConvert.setStatus(bonsai.getStatus());

        return bonsaiConvert;
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


