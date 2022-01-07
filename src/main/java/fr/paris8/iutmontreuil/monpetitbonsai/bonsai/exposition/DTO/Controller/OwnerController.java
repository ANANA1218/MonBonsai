package fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.Controller;


import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.domain.Modele.OwnerService;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.exposition.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.OwnerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/owner")

public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public OwnerService getOwnerService() {
        return ownerService;
    }

    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // OK
    @GetMapping
    public List<OwnerDTO> findAll() {
        return ownerService.findAll()
                .stream()
                .map(OwnerMapper:: OwnertoDto)
                .collect(Collectors.toList());
    }
//

    // OK
    @GetMapping("/{uuid}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(OwnerMapper:: OwnertoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> create(@RequestBody OwnerDTO ownerDTO) {
        Owner owner = ownerService.create(OwnerMapper.DtoToOwner(ownerDTO));
        ownerDTO = OwnerMapper.OwnertoDto(owner);
        return ResponseEntity.ok(ownerDTO);

    }

    @GetMapping("/{uuid}/bonsai")
    public ResponseEntity<OwnerDTO> findBonsai(@PathVariable("uuid") UUID uuid){

        return ownerService.findById(uuid)
                .map(OwnerMapper:: OwnertoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable UUID uuid) {
        ownerService.deleteById(uuid);
    }



}