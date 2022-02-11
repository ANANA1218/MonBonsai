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




}