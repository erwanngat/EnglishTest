package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Joueur idJoueur;

    public Partie() {
    }

    public Partie(Joueur idJoueur) {
        this.idJoueur = idJoueur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Joueur getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(Joueur idJoueur) {
        this.idJoueur = idJoueur;
    }
}
