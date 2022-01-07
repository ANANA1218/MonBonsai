package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.OwnerEntity;

public class OwnerMapper {


    public static OwnerDTO OwnertoDto(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO .setId(owner.getId());
        ownerDTO .setName(owner.getName());
        return ownerDTO ;
    }




    public static Owner DtoToOwner (OwnerDTO ownerDTO){
        Owner ownerdto = new Owner();
        ownerdto.setId(ownerDTO.getId());
        ownerdto.setName(ownerDTO.getName());

        return ownerdto;
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






}