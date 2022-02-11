package fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.BonsaiEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;


public class OwnerMapper {



    public static OwnerDTO OwnertoDto(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO .setId(owner.getId());
        ownerDTO .setName(owner.getName());

        return ownerDTO ;
    }




    public static Owner DtoToOwner (OwnerDTO ownerDTO){
        Owner owner = new Owner();
        owner.setId(ownerDTO.getId());
        owner.setName(ownerDTO.getName());
        return owner;
    }

    public static Owner EntityToOwner (OwnerEntity ownerEntity){
        Owner ownerentity = new Owner();
        ownerentity.setId(ownerEntity.getId());
        ownerentity.setName(ownerEntity.getName());

        return  ownerentity;
    }

    public static OwnerEntity OwnerToEntity (Owner owner){
        OwnerEntity ownerEntity= new OwnerEntity();
        ownerEntity.setId(owner.getId());
        ownerEntity.setName(owner.getName());


        return ownerEntity;
    }

    public static Bonsai EntityToBonsai(BonsaiEntity bonsaiEntity) {
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiEntity.getId());
        bonsai.setName(bonsaiEntity.getName());
        bonsai.setSpecies(bonsaiEntity.getSpecies());
        bonsai.setAcquisition_age(bonsaiEntity.getAcquisition_age());
        return bonsai;
    }

    public static Bonsai DTOtoBonsai(BonsaiDTO bonsaiDto) {
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiDto.getId());
        bonsai.setName(bonsaiDto.getName());
        bonsai.setSpecies(bonsaiDto.getSpecies());
        bonsai.setAcquisition_age(bonsaiDto.getAcquisition_age());
        return bonsai;
    }


    public static BonsaiDTO BonsaitoDto(Bonsai bonsai) {
        BonsaiDTO bonsaiDto = new BonsaiDTO();
        bonsaiDto.setId(bonsai.getId());
        bonsaiDto.setName(bonsai.getName());
        bonsaiDto.setSpecies(bonsai.getSpecies());
        bonsaiDto.setAcquisition_age(bonsai.getAcquisition_age());
        return bonsaiDto;
    }

    public static BonsaiEntity BonsaitoEntity(Bonsai bonsai) {
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setId(bonsai.getId());
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setAcquisition_age(bonsai.getAcquisition_age());
        return bonsaiEntity;
    }
}