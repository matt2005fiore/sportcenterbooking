package com.sportcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sportcenter.model.Pagamento;
import com.sportcenter.repository.PagamentoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamenti")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Create a new Pagamento
    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {
        Pagamento savedPagamento = pagamentoRepository.save(pagamento);
        return ResponseEntity.ok(savedPagamento);
    }

    // Retrieve all Pagamenti
    @GetMapping
    public ResponseEntity<List<Pagamento>> getAllPagamenti() {
        List<Pagamento> pagamenti = pagamentoRepository.findAll();
        return ResponseEntity.ok(pagamenti);
    }

    // Retrieve a single Pagamento by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getPagamentoById(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        return pagamento.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update an existing Pagamento
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> updatePagamento(
            @PathVariable Long id,
            @RequestBody Pagamento pagamentoDetails) {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);

        if (pagamentoOptional.isPresent()) {
            Pagamento existingPagamento = pagamentoOptional.get();
            existingPagamento.setImporto(pagamentoDetails.getImporto());
            existingPagamento.setDataOra(pagamentoDetails.getDataOra());
            existingPagamento.setCostoOrario(pagamentoDetails.getCostoOrario());
            Pagamento updatedPagamento = pagamentoRepository.save(existingPagamento);
            return ResponseEntity.ok(updatedPagamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Pagamento by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

        if (pagamento.isPresent()) {
            pagamentoRepository.delete(pagamento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
    