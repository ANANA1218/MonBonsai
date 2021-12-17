package fr.paris8.iutmontreuil.monpetitbonsai.owner.Repository;


import fr.paris8.iutmontreuil.monpetitbonsai.owner.DAO.OwnerDao;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Mappper.OwnerMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.OwnerEntity.OwnerEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class OwnerRepository {


    private static OwnerDao ownerDao;

    public OwnerRepository() {
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

    public void deleteById(UUID id) {
        ownerDao.deleteById(id);
    }
//



}
