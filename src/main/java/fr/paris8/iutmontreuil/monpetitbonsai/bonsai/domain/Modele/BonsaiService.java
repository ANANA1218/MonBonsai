package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiEntity;
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

    public Optional<Bonsai> update(UUID id, Bonsai updatedBonsai) {
        Optional<Bonsai> bonsai = repository.findById(id);
        if (bonsai.isPresent()) {
            bonsai.get().setName(updatedBonsai.getName());
            bonsai.get().setSpecies(updatedBonsai.getSpecies());
            bonsai.get().setAcquisition_date(updatedBonsai.getAcquisition_date());
            bonsai.get().setAcquisition_age(updatedBonsai.getAcquisition_age());
        }
        return bonsai;
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