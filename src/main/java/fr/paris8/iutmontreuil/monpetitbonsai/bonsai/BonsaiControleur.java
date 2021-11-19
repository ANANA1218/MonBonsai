package fr.paris8.iutmontreuil.monpetitbonsai.bonsai;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiControleur {

    private final BonsaiDao bonsaiDao;

    public BonsaiControleur(BonsaiDao bonsaiDao){
        this.bonsaiDao=bonsaiDao;
    }


    @GetMapping
    public List<BonsaiEntity> HelloWord(){
        return bonsaiDao.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiEntity> findById(@PathVariable("uuid") UUID uuid){
        return bonsaiDao.findById(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}



