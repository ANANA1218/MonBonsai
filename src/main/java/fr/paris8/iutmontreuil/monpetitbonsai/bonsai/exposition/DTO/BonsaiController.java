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

import static fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiMapper.EntityToBonsai;
import static fr.paris8.iutmontreuil.monpetitbonsai.bonsai.infrastuture.Repository.BonsaiMapper.bonsaiToDto;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {


    private BonsaiService bonsaiService;



    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = bonsaiService;
    }


    @GetMapping
    public List<BonsaiDTO> findAll() {
        return bonsaiService.findAll().stream()
                .map(BonsaiMapper::bonsaiToDto)
                .collect(Collectors.toList());
    }




    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid){
        return bonsaiService.findById(uuid)
                .map(BonsaiMapper::bonsaiToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




    @PostMapping
    public BonsaiDTO create(@RequestBody Bonsai bonsai) {
        Bonsai bonsai1= EntityToBonsai(bonsai);
        Bonsai postCreated = bonsaiService.create(bonsai1);
        return bonsaiToDto(postCreated);
    }





    @PutMapping
    public void updateStatuts(@RequestBody Bonsai bonsai) {
        Bonsai bonsai1= EntityToBonsai(bonsai);
        bonsaiService.update(bonsai1);
    }




    @DeleteMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> delete(@PathVariable("uuid") UUID uuid){
        bonsaiService.deleteById(uuid);
        return ResponseEntity.ok().build();

    }




    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> update(@RequestBody BonsaiDTO bonsai, @PathVariable("uuid") UUID uuid){
            return bonsaiService.findById(uuid)
                    .map(BonsaiMapper::bonsaiToDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }




}