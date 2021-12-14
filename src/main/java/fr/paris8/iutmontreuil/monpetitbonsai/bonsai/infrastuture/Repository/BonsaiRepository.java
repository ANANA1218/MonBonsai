package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Pruning;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Repotting;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Watering;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BonsaiRepository{

    private BonsaiDao bonsaiDao;
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






    //a modifier

    public BonsaiEntity create(BonsaiEntity bonsai){
        return bonsaiDao.save(bonsai);
    }
//

    // a modifier
    public Bonsai updat(Bonsai bonsai, UUID id){
        return bonsai;
    }

//

    // a modifier
    public Bonsai updatStatus(Bonsai bonsai, UUID id){
        return bonsai;
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
                .map(BonsaiMapper::EntityToWatering)
                .sorted(Comparator.comparing(Watering::getWatering_date).reversed())
                .collect(Collectors.toList());
    }
//

    //ok
    public List<Repotting> getRepotting(UUID id) {
        return repottingDao.findAll().stream()
                .map(BonsaiMapper::EntityToRepotting)
                .sorted(Comparator.comparing(Repotting::getRepotting_date).reversed())
                .collect(Collectors.toList());
    }
//

    //ok
    public List<Pruning> getPruning(UUID id) {
        return pruningDao.findAll().stream()
                .map(BonsaiMapper::EntityToPruning)
                .sorted(Comparator.comparing(Pruning::getPruning_date).reversed())
                .collect(Collectors.toList());
    }

//




}

