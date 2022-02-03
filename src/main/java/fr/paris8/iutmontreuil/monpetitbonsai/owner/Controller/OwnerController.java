package fr.paris8.iutmontreuil.monpetitbonsai.owner.Controller;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.Bonsai;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Mapper.BonsaiMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Mapper.OwnerMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public List<BonsaiDTO> getBonsai(@PathVariable UUID uuid) {
        return ownerService.getBonsai(uuid)
                .stream()
                .map(OwnerMapper::BonsaitoDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiDTO> transferBonsaiToAnOwner(@PathVariable("owner_id") String owner_id, @PathVariable("bonsai_id") String bonsai_id, @RequestBody String new_owner_id) {

            Optional<Bonsai> bonsai = ownerService.transferBonsaiToOwner(UUID.fromString(owner_id), UUID.fromString(bonsai_id), UUID.fromString(owner_id));

            BonsaiDTO bonsaiDTO = BonsaiMapper.BonsaitoDto(bonsai);

            return ResponseEntity.ok(bonsaiDTO);
        }


    @PostMapping("/{owner_id}/bonsais")
    public ResponseEntity<Void> updateOwnerOfBonsaisWithNoOwner(@PathVariable("owner_id") String owner_id, @RequestBody List<String> bonsaisUUID) {

            ownerService.addBonsaiToOwner(UUID.fromString(owner_id), bonsaisUUID.stream().map(UUID::fromString).collect(Collectors.toList()));
            return ResponseEntity.noContent().build();

            return ResponseEntity.notFound().build();


}




}