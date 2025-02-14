package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 100)
    private String nom;

    @OneToMany(mappedBy = "country")
    private List<Member> members;

    public Country() {
    }

    public Country(String nom) {
        this.nom = nom;
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
}
