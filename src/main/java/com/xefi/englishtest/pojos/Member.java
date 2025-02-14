package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;
    @Column(length = 100)
    private String email;
    @Column(length = 20)
    private String telephone;
    @Column(length = 20)
    private LocalDate date;
    @Column(length = 10)
    private String sexe;
    @Column(length = 100)
    private String pays;
    @Column(length = 100)
    private String password;

    @ManyToOne
    private Country country;

    public Member() {
    }

    public Member(String nom, String prenom, String email, LocalDate date, String telephone, String sexe, String pays, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.telephone = telephone;
        this.sexe = sexe;
        this.pays = pays;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
