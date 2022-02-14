package fr.paris8.iutmontreuil.monpetitbonsai.owner.Controller;

import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.BonsaiDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.DTO.OwnerDTO;
import fr.paris8.iutmontreuil.monpetitbonsai.commons.infrastructure.OwnerMapper;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Owner;
import fr.paris8.iutmontreuil.monpetitbonsai.owner.Service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMIN')")
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


}