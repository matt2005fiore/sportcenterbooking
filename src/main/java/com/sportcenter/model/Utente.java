
package com.sportcenter.model;


import java.util.*;

import jakarta.persistence.*;


@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;


    

    @ManyToMany
    @JoinTable(
        name = "user_roles", // Nome della tabella di join
        joinColumns = @JoinColumn(name = "user_id"), // Colonna di join per User
        inverseJoinColumns = @JoinColumn(name = "role_id") // Colonna di join per Role
    )

    private Set<Ruolo> ruoli;






    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ruolo> getRuoli() {
        return ruoli;
    }

    public void setRuoli(Set<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }

}
