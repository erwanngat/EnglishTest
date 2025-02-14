package com.xefi.englishtest.pojos;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Partie partie;
    @ManyToOne
    private Verbe verbe;
    @Column(name = "reponsePreterit", length = 100)
    private String reponsePreterit;
    @Column(name = "reponseParticipePasse", length = 100)
    private String reponseParticipePasse;
    @Column(name = "dateEnvoie")
    private Timestamp dateEnvoie;
    @Column(name = "dateReponse")
    private Timestamp dateReponse;

    public Question() {
    }

    public Question(Partie partie, Verbe verbe, String reponsePreterit, String reponseParticipePasse, Timestamp dateEnvoie, Timestamp dateReponse) {
        this.partie = partie;
        this.verbe = verbe;
        this.reponsePreterit = reponsePreterit;
        this.reponseParticipePasse = reponseParticipePasse;
        this.dateEnvoie = dateEnvoie;
        this.dateReponse = dateReponse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public Verbe getVerbe() {
        return verbe;
    }

    public void setVerbe(Verbe idVerbe) {
        this.verbe = verbe;
    }

    public String getReponsePreterit() {
        return reponsePreterit;
    }

    public void setReponsePreterit(String reponsePreterit) {
        this.reponsePreterit = reponsePreterit;
    }

    public String getReponseParticipePasse() {
        return reponseParticipePasse;
    }

    public void setReponseParticipePasse(String reponseParticipePasse) {
        this.reponseParticipePasse = reponseParticipePasse;
    }

    public Timestamp getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Timestamp dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Timestamp getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Timestamp dateReponse) {
        this.dateReponse = dateReponse;
    }
}
