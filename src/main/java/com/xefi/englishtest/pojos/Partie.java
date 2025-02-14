package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

@Entity
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Joueur joueur;

    public Partie() {
    }

    public Partie(Joueur idJoueur) {
        this.joueur = joueur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
