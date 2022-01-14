package fr.paris8.iutmontreuil.monpetitbonsai.owner.Service;


import fr.paris8.iutmontreuil.monpetitbonsai.owner.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private OwnerRepository orepository;




    public OwnerService(OwnerRepository repository) {
        this.orepository = repository;
    }




    public Optional<Owner> findById(UUID id) {
        return orepository.findById(id);
    }

    public List<Owner> findAll() {
        return orepository.findAll();
    }


    public Owner create(Owner owner) {
        return orepository.create(owner);
    }


    public void deleteById(UUID id) {
        orepository.deleteById(id);
    }

    public List<Bonsai> getBonsai(UUID id) {
        return orepository.getBonsai(id);
    }


    public Optional<Bonsai> transferBonsaiToOwner(UUID owner_id, UUID bonsai_id, Owner new_owner) {

        Optional<Owner> owner = orepository.findById(owner_id);
        Optional<Bonsai> bonsai = orepository.findBonsaiById(bonsai_id);

        if (bonsai.isPresent() && owner.isPresent()) {

            return Optional.of(orepository.transferBonsaiToOwner(new_owner, bonsai.get()));
        }


        return Optional.empty();
    }

    public List<Bonsai> addBonsaiToOwner(UUID owner_id, List<Bonsai> bonsai) {

        List<Bonsai> listeBonsai = new ArrayList<>();
        Optional<Owner> owner = orepository.findById(owner_id);

        if(owner.isPresent()){
            for(Bonsai b : bonsai){
                if(b.getOwnerId() != null){
                    listeBonsai.add(orepository.addBonsaiToOwner(owner.get(),b));
                }
            }
        }

        return listeBonsai;
    }


}