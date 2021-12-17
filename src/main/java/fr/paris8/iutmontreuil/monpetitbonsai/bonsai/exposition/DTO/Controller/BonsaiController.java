package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.Controller;

import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.BonsaiService;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.PruningDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.RepottingDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.WateringDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiMapper;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Mappper.OwnerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiDTO bonsaiDTO) {
        Bonsai bonsai = bonsaiService.create(BonsaiMapper.DtoToBonsai(bonsaiDTO));
        bonsaiDTO = BonsaiMapper.bonsaiToDto(bonsai);
        return ResponseEntity.ok(bonsaiDTO);

    }


    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> update(@PathVariable UUID uuid, @RequestBody BonsaiDTO bonsaiDTO) {

        return bonsaiService.update(uuid, BonsaiMapper.DtoToBonsai(bonsaiDTO))
                .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{uuid}/status")
   public  ResponseEntity<BonsaiDTO> statusUpdate(@PathVariable UUID uuid, @RequestBody String status){

      return bonsaiService.statusUpdate(uuid, status)
              .map(bonsai -> ResponseEntity.ok(BonsaiMapper.bonsaiToDto(bonsai)))
               .orElse(ResponseEntity.notFound().build());
    }



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
                .filter(watering -> watering.getBonsai().getId().equals(uuid))
                .map(BonsaiMapper::wateringToDto)
                .collect(Collectors.toList());
    }
//

    // OK
    @GetMapping("/{uuid}/repotting")
    public List<RepottingDTO> getRepotting(@PathVariable UUID uuid) {
        return bonsaiService.getRepotting(uuid)
                .stream()
                .filter(repotting-> repotting.getBonsai().getId().equals(uuid))
                .map(BonsaiMapper::RepottingToDto)
                .collect(Collectors.toList());
    }
//
// OK
@GetMapping("/{uuid}/repotting")
public List<OwnerDTO> getOwner(@PathVariable UUID uuid) {
    return bonsaiService.getOwner(uuid)
            .stream()
            .filter(owner-> owner.getBonsai().equals(uuid))
            .map(OwnerMapper:: OwnertoDto)
            .collect(Collectors.toList());
}
//

    // OK
    @GetMapping("/{uuid}/pruning")
    public List<PruningDTO> getPruning(@PathVariable UUID uuid) {
        return bonsaiService.getPruning(uuid)
                .stream()
                .filter(pruning -> pruning.getBonsai().getId().equals(uuid))
                .map(BonsaiMapper::PruningtoDto)
                .collect(Collectors.toList());
    }
    //


}

