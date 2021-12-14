package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.BonsaiService;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiEntity;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {


    private BonsaiService bonsaiService;


    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = bonsaiService;
    }

    // OK
    @GetMapping
    public List<BonsaiDTO> findAll() {
        return bonsaiService.findAll()
                .stream()
                .map(BonsaiMapper:: bonsaiToDto)
                .collect(Collectors.toList());
    }
//


    // OK
    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid){
        return bonsaiService.findById(uuid)
                .map(BonsaiMapper:: bonsaiToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//



    // modifier
    @PostMapping

    public BonsaiEntity create(@RequestBody BonsaiEntity bonsai){
        return bonsaiService.create(bonsai);
    }

    //


    // modifier
    @PatchMapping("/{uuid}")
    public BonsaiService updat(@RequestBody BonsaiEntity bonsai, @PathVariable("uuid") UUID uuid) {

        return bonsaiService;
    }
    //

    // modifier
    @PutMapping("/{uuid}")
    public BonsaiService updatStatus(@RequestBody BonsaiEntity bonsai, @PathVariable("uuid") UUID uuid) {

        return bonsaiService;
    }
    //


    // OK
    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable UUID uuid) {
        bonsaiService.deleteById(uuid);
    }
    //


    // OK
    @GetMapping("/{uuid}/watering")
    public List<WateringDTO> getWatering(@PathVariable UUID uuid) {
        return bonsaiService.getWatering(uuid)
                .stream()
                .map(BonsaiMapper::wateringToDto)
                .collect(Collectors.toList());
    }
//

    // OK
    @GetMapping("/{uuid}/repotting")
    public List<RepottingDTO> getRepotting(@PathVariable UUID uuid) {
        return bonsaiService.getRepotting(uuid)
                .stream()
                .map(BonsaiMapper::RepottingToDto)
                .collect(Collectors.toList());
    }
//


    // OK
    @GetMapping("/{uuid}/pruning")
    public List<PruningDTO> getPruning(@PathVariable UUID uuid) {
        return bonsaiService.getPruning(uuid)
                .stream()
                .map(BonsaiMapper::PruningtoDto)
                .collect(Collectors.toList());
    }
    //


}

