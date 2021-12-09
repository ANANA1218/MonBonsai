package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BonsaiService {



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


    public Bonsai update(Bonsai bonsai) {
        return repository.update(bonsai);
    }


    public Bonsai create(Bonsai bonsai) {
        return repository.create(bonsai);
    }

    public Bonsai updateStatuts(Bonsai bonsai) {
        return repository.update(bonsai);
    }


    public void deleteById(UUID id) {
        repository.deleteById(id);
    }




}