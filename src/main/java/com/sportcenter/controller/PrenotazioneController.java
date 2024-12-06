package com.sportcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sportcenter.model.Prenotazione;
import com.sportcenter.repository.PrenotazioneRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    // Create a new Prenotazione
    @PostMapping
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione prenotazione) {
        Prenotazione savedPrenotazione = prenotazioneRepository.save(prenotazione);
        return ResponseEntity.ok(savedPrenotazione);
    }

    // Retrieve all Prenotazioni
    @GetMapping
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        return ResponseEntity.ok(prenotazioni);
    }

    // Retrieve a single Prenotazione by ID
    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        return prenotazione.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an existing Prenotazione
    @PutMapping("/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(
            @PathVariable Long id,
            @RequestBody Prenotazione prenotazioneDetails) {
        Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(id);

        if (prenotazioneOptional.isPresent()) {
            Prenotazione existingPrenotazione = prenotazioneOptional.get();
            existingPrenotazione.setDataOra(prenotazioneDetails.getDataOra());
            existingPrenotazione.setStato(prenotazioneDetails.getStato());
            existingPrenotazione.setCampoSportivo(prenotazioneDetails.getCampoSportivo());
            existingPrenotazione.setPagamento(prenotazioneDetails.getPagamento());
            existingPrenotazione.setUtente(prenotazioneDetails.getUtente());
            Prenotazione updatedPrenotazione = prenotazioneRepository.save(existingPrenotazione);
            return ResponseEntity.ok(updatedPrenotazione);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Prenotazione by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);

        if (prenotazione.isPresent()) {
            prenotazioneRepository.delete(prenotazione.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
