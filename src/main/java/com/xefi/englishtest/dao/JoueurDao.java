package com.xefi.englishtest.dao;

import com.xefi.englishtest.pojos.Joueur;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class JoueurDao extends Dao {

    public Joueur findById(Long id) {
        Joueur joueur = null;
        try {
            session = openSession();
            joueur = (Joueur)session.get(Joueur.class, id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return joueur;
    }

    public Joueur findByEmail(String email) {
        Joueur joueur = null;
        try {
            session = openSession();
            Query<Joueur> query = session.createQuery("select j from Joueur as j where email = :email", Joueur.class);
            query.setParameter("email", email);
            joueur = query.getSingleResultOrNull();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return joueur;
    }

    public List<Joueur> findAll() {
        List<Joueur> joueurs = null;
        try {
            session = openSession();
            joueurs = session.createQuery("from Joueur").list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return joueurs;
    }

    public Joueur create(Joueur joueur) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.persist(joueur);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return joueur;
    }

    public Joueur update(Joueur joueur) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.merge(joueur);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return joueur;
    }

    public void delete(Joueur joueur) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.remove(joueur);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
    }
}