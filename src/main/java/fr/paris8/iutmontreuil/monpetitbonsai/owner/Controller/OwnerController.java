package fr.paris8.iutmontreuil.monpetitbonsai.owner.Controller;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Mapper.OwnerMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Service.OwnerService;
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

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable UUID uuid) {
        ownerService.deleteById(uuid);
    }

    @GetMapping("/{id}/bonsai")
    public List<BonsaiDTO> getBonsai(@PathVariable UUID id) {
        return ownerService.getBonsai(id)
                .stream()
                .map(OwnerMapper::BonsaitoDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/{owner_id}/bonsai/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO> transferBonsaiToOwner(@PathVariable UUID owner_id, @PathVariable UUID bonsai_id, @RequestBody Owner new_owner) {

        return ownerService.transferBonsaiToOwner(owner_id,bonsai_id,new_owner)
                .map(bonsai -> ResponseEntity.ok(OwnerMapper.BonsaitoDto(bonsai)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping("/{owner_id}/bonsai")
    public List<BonsaiDTO> addBonsaiToOwner(@PathVariable UUID owner_id, @RequestBody List<Bonsai> bonsai) {

        return ownerService.addBonsaiToOwner(owner_id,bonsai)
                .stream()
                .map(OwnerMapper::BonsaitoDto)
                .collect(Collectors.toList());
    }




}