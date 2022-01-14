package fr.paris8.iutmontreuil.monpetitbonsai.owner.Mapper;

import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.BonsaiEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.BonsaiDTO;

public class BonsaiMapper {

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
