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

    public List<Bonsai> getBonsai(UUID uuid) {
        return orepository.getBonsai(uuid);
    }


    public Optional<Bonsai> transferBonsaiToOwner(UUID owner_id, UUID bonsai_id, Owner new_owner) {
        Optional<Owner> owner = orepository.findById(owner_id);
        Optional<Bonsai> bonsai = orepository.findBonsaiById(bonsai_id);
        if (owner.isPresent() && bonsai.isPresent()) {
            for (fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai b : owner.get().getBonsai()) {
                if (b.getId().equals(bonsai_id)) {
                    return Optional.of(orepository.transferBonsaiToOwner(new_owner, bonsai.get()));
                }
            }
        }
        return Optional.empty();
    }

    public List<Bonsai> addBonsaiToOwner(UUID owner_id, List<Bonsai> bonsais) {
        List<Bonsai> list = new ArrayList<>();
        Optional<Owner> owner = orepository.findById(owner_id);
        if (owner.isPresent()) {
            for (Bonsai bonsai : bonsais) {
                boolean hasOwnerAlready = false;
                for (Owner o : findAll()) {
                    for (fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai b : o.getBonsai()) {
                        if (b.getId().equals(bonsai.getId())) {
                            hasOwnerAlready = true;
                        }
                    }
                }
                if (!hasOwnerAlready) {
                    list.add(orepository.addBonsaiToOwner(owner.get(), bonsai));
                }
            }
        }
        return list;
    }
}

