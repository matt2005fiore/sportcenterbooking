package com.sportcenter.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Pagamento {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private double importo;

    private LocalDateTime dataOra;
    private double costoOrario;
    


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
     * @return double return the importo
     */
    public double getImporto() {
        return importo;
    }

    /**
     * @param importo the importo to set
     */
    public void setImporto(double importo) {
        this.importo = importo;
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
     * @return double return the costoOrario
     */
    public double getCostoOrario() {
        return costoOrario;
    }

    /**
     * @param costoOrario the costoOrario to set
     */
    public void setCostoOrario(double costoOrario) {
        this.costoOrario = costoOrario;
    }

}
