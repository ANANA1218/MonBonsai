package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BonsaiRepository {

    private static BonsaiDao bonsaiDao;



    public BonsaiRepository(BonsaiDao bonsaiDao) {
        this.bonsaiDao = bonsaiDao;
    }



    public Optional<Bonsai> findById(UUID id) {
        return bonsaiDao.findById(id.toString())
                .map(BonsaiMapper::EntityToBonsai);
    }



    public List<Bonsai> findAll() {
        return bonsaiDao.findAll().stream()
                .map(BonsaiMapper::EntityToBonsai)
                .collect(Collectors.toList());
    }






    public Bonsai create(Bonsai bonsai) {


        BonsaiEntity bonsaiToSave = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity save = bonsaiDao.save(bonsaiToSave);
        return BonsaiMapper.EntityToBonsai(save);
    }


    public Bonsai updateStatuts(BonsaiEntity bonsai) {

        BonsaiEntity save = bonsaiDao.save(bonsai);
        return BonsaiMapper.EntityToBonsai(save);

    }



    public void deleteById(UUID id) {
        bonsaiDao.deleteById(id.toString());
    }


    public Bonsai update(Bonsai bonsai) {

        BonsaiEntity bonsaiToSave = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity save = bonsaiDao.save(bonsaiToSave);
        return BonsaiMapper.EntityToBonsai(save);
    }











}


