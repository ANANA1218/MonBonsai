package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.*;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.BonsaiDao;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.PruningDao;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.RepottingDao;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.WateringDao;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.BonsaiEntity;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BonsaiRepository{

    private  BonsaiDao bonsaiDao;
    private WateringDao wateringDao;
    private RepottingDao repottingDao;
    private PruningDao pruningDao;

    public BonsaiRepository(BonsaiDao bonsaiDao, WateringDao wateringDao, RepottingDao repottingDao, PruningDao pruningDao) {
        this.bonsaiDao = bonsaiDao;
        this.wateringDao = wateringDao;
        this.repottingDao = repottingDao;
        this.pruningDao = pruningDao;
    }

    //ok
    public Optional<Bonsai> findById(UUID uuid) {
        return bonsaiDao.findById(uuid)
                .map(BonsaiMapper::EntityToBonsai);

    }
//

    //ok
    public List<Bonsai> findAll() {
        return bonsaiDao.findAll().stream()
                .map(BonsaiMapper::EntityToBonsai)
                .collect(Collectors.toList());
    }

//

    //a voir si c bon
    public Bonsai create(Bonsai bonsai){

        BonsaiEntity bonsaiEntity = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity save = bonsaiDao.save(bonsaiEntity);

        return BonsaiMapper.EntityToBonsai(save);
    }
//

    // a modifier
    public Bonsai update(Bonsai bonsai){
        BonsaiEntity bonsaiEntity = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity update = bonsaiDao.save(bonsaiEntity);

        return BonsaiMapper.EntityToBonsai(update);
    }

//

    // a modifier
    public Bonsai statusUpdate(Bonsai bonsai, UUID id){
        BonsaiEntity bonsaiEntity = BonsaiMapper.BonsaiToEntity(bonsai);
        BonsaiEntity statusUpdate = bonsaiDao.save(bonsaiEntity);

        return BonsaiMapper.EntityToBonsai(statusUpdate);
    }

//
//ok

    public void deleteById(UUID id) {
        bonsaiDao.deleteById(id);
    }
//






    //ok
    public List<Watering> getWatering(UUID id) {
        return wateringDao.findAll().stream()
                .filter(watering -> watering.getBonsai().getId().equals(id))
                .map(BonsaiMapper::EntityToWatering)
                .sorted(Comparator.comparing(Watering::getWatering_date).reversed())
                .collect(Collectors.toList());
    }
//



    //ok
    public List<Repotting> getRepotting(UUID id) {
        return repottingDao.findAll().stream()
                .filter(repotting -> repotting.getBonsai().getId().equals(id))
                .map(BonsaiMapper::EntityToRepotting)
                .sorted(Comparator.comparing(Repotting::getRepotting_date).reversed())
                .collect(Collectors.toList());
    }
//

    //ok
    public List<Pruning> getPruning(UUID id) {
        return pruningDao.findAll().stream()
                .filter(pruning -> pruning.getBonsai().getId().equals(id))
                .map(BonsaiMapper::EntityToPruning)
                .sorted(Comparator.comparing(Pruning::getPruning_date).reversed())
                .collect(Collectors.toList());
    }






}

