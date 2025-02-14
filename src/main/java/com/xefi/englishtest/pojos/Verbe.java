package com.xefi.englishtest.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Verbe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "baseVerbal", length = 100)
    private String baseVerbal;
    @Column(name = "preterit", length = 100)
    private String preterit;
    @Column(name = "participePasse", length = 100)
    private String participePasse;
    @Column(name = "traduction", length = 100)
    private String traduction;

    public Verbe() {
    }

    public Verbe(String baseVerbal, String preterit, String participePasse, String traduction) {
        this.baseVerbal = baseVerbal;
        this.preterit = preterit;
        this.participePasse = participePasse;
        this.traduction = traduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaseVerbal() {
        return baseVerbal;
    }

    public void setBaseVerbal(String baseVerbal) {
        this.baseVerbal = baseVerbal;
    }

    public String getPreterit() {
        return preterit;
    }

    public void setPreterit(String preterit) {
        this.preterit = preterit;
    }

    public String getParticipePasse() {
        return participePasse;
    }

    public void setParticipePasse(String participePasse) {
        this.participePasse = participePasse;
    }

    public String getTraduction() {
        return traduction;
    }

    public void setTraduction(String traduction) {
        this.traduction = traduction;
    }
}
