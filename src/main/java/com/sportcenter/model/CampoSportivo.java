package com.sportcenter.model;



import java.util.List;

import jakarta.persistence.*;



@Entity
public class CampoSportivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String disciplina;

    private boolean disponibile;
    private double costoOrario;

    @OneToMany(mappedBy = "campoSportivo")

    private List<Prenotazione> prenotazione;


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
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return boolean return the disponibile
     */
    public boolean isDisponibile() {
        return disponibile;
    }

    /**
     * @param disponibile the disponibile to set
     */
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
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
