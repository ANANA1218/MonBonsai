package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Component
public class BonsaiRepository{

    private final BonsaiDao bonsaiDao;



    public BonsaiRepository(BonsaiDao bonsaiDao) {
        this.bonsaiDao = bonsaiDao;
    }


    @GetMapping
    public List<BonsaiEntity> FindAllBonsai(){

        return bonsaiDao.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiEntity> findById(@PathVariable("uuid") UUID uuid){
        return bonsaiDao.findById(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public BonsaiEntity create(@RequestBody BonsaiEntity bonsai){
        return bonsaiDao.save(bonsai);
    }





        }
