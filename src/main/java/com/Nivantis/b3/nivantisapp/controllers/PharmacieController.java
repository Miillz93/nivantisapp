package com.Nivantis.b3.nivantisapp.controllers;

import com.Nivantis.b3.nivantisapp.models.Medicaments;
import com.Nivantis.b3.nivantisapp.models.Pharmacie;
import com.Nivantis.b3.nivantisapp.repositories.PharmacieRepository;
import com.Nivantis.b3.nivantisapp.repositories.ProductlistReprositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PharmacieController {

    @Autowired
    PharmacieRepository pharmacieRepository;

    @Autowired
    private ProductlistReprositories medicamentRepository;

    @GetMapping("/pharmacie")
    public List<Pharmacie> getAllPharmacies() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return pharmacieRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/pharmacie")
    public Pharmacie createPharmacie(@Valid @RequestBody Pharmacie pharmacie) {

        pharmacie.setMatricule(pharmacie.getMatricule());
        pharmacie.setNom(pharmacie.getNom());
        pharmacie.setGerant(pharmacie.getGerant());
        pharmacie.setAdresse(pharmacie.getAdresse());
        pharmacie.setCode(pharmacie.getCode());
        pharmacie.setVille(pharmacie.getVille());
        pharmacie.setRegion(pharmacie.getRegion());

        return pharmacieRepository.save(pharmacie);
    }

    @GetMapping(value="/pharmacie/{id}")
    public ResponseEntity<Pharmacie> getPharmacieById(@PathVariable("id") String id) {
        return pharmacieRepository.findById(id)
                .map(pharmacie -> ResponseEntity.ok().body(pharmacie))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/pharmacie/{id}")
    public ResponseEntity<Pharmacie> updatePharmacie(@PathVariable("id") String id,
                                           @Valid @RequestBody Pharmacie pharmacie ) {
        return pharmacieRepository.findById(id)
                .map(pharmacieData -> {
                    pharmacieData.setMatricule(pharmacie.getMatricule());
                    pharmacieData.setNom(pharmacie.getNom());
                    pharmacieData.setGerant(pharmacie.getGerant());
                    pharmacieData.setAdresse(pharmacie.getAdresse());
                    pharmacieData.setCode(pharmacie.getCode());
                    pharmacieData.setVille(pharmacie.getVille());
                    pharmacieData.setRegion(pharmacie.getRegion());

                    Pharmacie updatedPharmacie = pharmacieRepository.save(pharmacieData);
                    return ResponseEntity.ok().body(updatedPharmacie);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/pharmacie/{id}")
    public ResponseEntity<?> deletePharmacie(@PathVariable("id") String id) {
        return pharmacieRepository.findById(id)
                .map(pharmacie -> {
                    pharmacieRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/medicament" , method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Medicaments> getMedicamentsList() {
        return  medicamentRepository.findAll();
    }



}
