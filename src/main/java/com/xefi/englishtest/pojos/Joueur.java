package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email", length = 200)
    private String email;
    @Column(name = "nom", length = 100)
    private String nom;
    @Column(name = "prenom", length = 100)
    private String prenom;
    @Column(name = "motDePasse", length = 100)
    private String motDePasse;
    @ManyToOne
    private Ville idVille;
    @Column(name = "niveau", length = 100)
    private String niveau;

    public Joueur() {
    }

    public Joueur(String email, String nom, String prenom, String motDePasse, Ville idVille, String niveau) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.idVille = idVille;
        this.niveau = niveau;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Ville getIdVille() {
        return idVille;
    }

    public void setIdVille(Ville idVille) {
        this.idVille = idVille;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
