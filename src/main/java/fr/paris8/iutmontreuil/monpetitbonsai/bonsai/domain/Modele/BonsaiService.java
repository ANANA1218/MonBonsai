package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiRepository;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.*;

@Service
public class BonsaiService {

    @OneToMany
    private BonsaiRepository repository;

    public BonsaiService(BonsaiRepository repository){
        this.repository=repository;
    }
    public Optional<Bonsai> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Bonsai> findAll() {
        return repository.findAll();
    }


    public Bonsai create(Bonsai bonsai) {
        return repository.create(bonsai);
    }


    public Optional<Bonsai> update(UUID id, Bonsai bonsai) {

        Optional<Bonsai> bonsaiUpdate = repository.findById(id);

        if (bonsaiUpdate.isPresent()) {
            bonsaiUpdate.get().setName(bonsai.getName());
            bonsaiUpdate.get().setSpecies(bonsai.getSpecies());
            bonsaiUpdate.get().setAcquisition_date(bonsai.getAcquisition_date());
            bonsaiUpdate.get().setAcquisition_age(bonsai.getAcquisition_age());
            return Optional.of(BonsaiRepository.update(bonsaiUpdate.get()));
        }
        return bonsaiUpdate;
    }

    public Optional<Bonsai> statusUpdate(UUID id, Bonsai bonsai) {

        Optional<Bonsai> bonsaiPut = repository.findById(id);

        if (bonsaiPut.isPresent()) {
            bonsaiPut.get().setName(bonsai.getName());
            bonsaiPut.get().setSpecies(bonsai.getSpecies());
            bonsaiPut.get().setAcquisition_date(bonsai.getAcquisition_date());
            bonsaiPut.get().setAcquisition_age(bonsai.getAcquisition_age());
            return Optional.of(BonsaiRepository.update(bonsaiPut.get()));
        }
        return bonsaiPut;
    }


    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public List<Watering> getWatering(UUID uuid) {
        return repository.getWatering(uuid);
    }





    public List<Repotting> getRepotting(UUID uuid) {
        return repository.getRepotting(uuid);
    }
    public List<Pruning> getPruning(UUID uuid) {
        return repository.getPruning(uuid);
    }


}