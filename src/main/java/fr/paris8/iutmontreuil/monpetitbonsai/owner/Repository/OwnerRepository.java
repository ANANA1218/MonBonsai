package fr.paris8.iutmontreuil.monpetitbonsai.owner.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.BonsaiDao;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerDAO;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerMapper;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class OwnerRepository {



    private OwnerDAO ownerDao;
    private BonsaiDao bonsaiDao;


    public OwnerRepository(OwnerDAO ownerDao, BonsaiDao bonsaiDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
    }

    //ok
    public Optional<Owner> findById(UUID uuid) {
        return ownerDao.findById(uuid)
                .map(OwnerMapper::EntityToOwner);

    }
//

    //ok
    public List<Owner> findAll() {
        return ownerDao.findAll().stream()
                .map(OwnerMapper::EntityToOwner)
                .collect(Collectors.toList());
    }

//

    public Owner create(Owner owner){

        OwnerEntity ownerEntity = OwnerMapper.OwnerToEntity(owner);
        OwnerEntity save = ownerDao.save(ownerEntity);

        return OwnerMapper.EntityToOwner(save);
    }



//ok

    public void deleteById(UUID uuid) {
        ownerDao.deleteById(uuid);
    }
//

    public List<Bonsai> getBonsai(UUID id) {
        return bonsaiDao.findAll().stream()
                .filter(b -> b.getOwnerEntity() != null && b.getOwnerEntity().getId().equals(id))
                .map(OwnerMapper::EntityToBonsai)
                .collect(Collectors.toList());
    }






}