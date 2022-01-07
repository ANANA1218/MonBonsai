package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.DAO.BonsaiDao;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.DAO.OwnerDAO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.Entity.OwnerEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class OwnerRepository {


    private OwnerDAO ownerDao;
    private BonsaiDao bonsaiDao;

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

// A CHANGER JE SAIS PAS QUOI FAIRE AVEC
    public Optional<Bonsai> findBonsai(UUID uuid) {
        return bonsaiDao.findById(uuid)
                .map(BonsaiMapper::EntityToBonsai);

    }
    //

//ok


    public void deleteById(UUID id) {
        ownerDao.deleteById(id);
    }
//



}