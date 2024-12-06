package com.sportcenter.model;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;

@Entity
public class Prenotazione {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private Long id;

    private LocalDateTime dataOra;

    private String Stato;
@ManyToOne
@JoinColumn(name="id_campo_sportivo")
private CampoSportivo campoSportivo;


     @OneToOne
    @JoinColumn(name="id_pagamento")


    private Pagamento pagamento;

@ManyToOne
@JoinColumn(name = "id_utente")
private Utente utente;

    
    











    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return LocalDateTime return the dataOra
     */
    public LocalDateTime getDataOra() {
        return dataOra;
    }

    /**
     * @param dataOra the dataOra to set
     */
    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    /**
     * @return String return the Stato
     */
    public String getStato() {
        return Stato;
    }

    /**
     * @param Stato the Stato to set
     */
    public void setStato(String Stato) {
        this.Stato = Stato;
    }

    public Object getCampoSportivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCampoSportivo'");
    }

    public void setCampoSportivo(Object campoSportivo2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCampoSportivo'");
    }

    public Object getPagamento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPagamento'");
    }

    public Object getUtente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUtente'");
    }

    public void setPagamento(Object pagamento2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPagamento'");
    }

    public void setUtente(Object utente2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUtente'");
    }

}
