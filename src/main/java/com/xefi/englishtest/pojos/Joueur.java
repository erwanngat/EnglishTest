package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

@Entity
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
    @JoinColumn(name = "idVille")
    private Ville ville;
    @Column(name = "niveau", length = 100)
    private String niveau;

    public Joueur() {
    }

    public Joueur(String email, String nom, String prenom, String motDePasse, Ville ville, String niveau) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.ville = ville;
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville idVille) {
        this.ville = ville;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
