package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.BonsaiService;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bonsai")
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
    @PostMapping("/bonsai")

    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiDTO bonsaiDTO) {
        Bonsai bonsai = bonsaiService.create(BonsaiMapper.DtoToBonsai(bonsaiDTO));
        bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai);
        return ResponseEntity.ok(bonsaiDTO);

    }


        // modifier
        @PatchMapping("/{uuid}")

      // public ResponseEntity<BonsaiDTO> update(@RequestBody BonsaiDTO bonsaiDTO) {

 //  }

    // modifier
    @PutMapping("/{uuid}")


        //  public ResponseEntity<BonsaiDTO> updateStatus(@RequestBody BonsaiDTO bonsaiDTO) {
        //      Bonsai bonsai = bonsaiService.update(BonsaiMapper.DtoToBonsai(bonsaiDTO));
        //     bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai);
        //     return ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai));

        //  }


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

