package com.xefi.englishtest.dao;

import com.xefi.englishtest.pojos.Partie;
import org.hibernate.Transaction;
import java.util.List;

public class PartieDao extends Dao {

    public Partie findById(Long id) {
        Partie partie = null;
        try {
            session = openSession();
            partie = (Partie)session.get(Partie.class, id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return partie;
    }

    public List<Partie> findByJoueurId(Long joueurId) {
        List<Partie> parties = null;
        try {
            session = openSession();
            parties = session.createQuery("from Partie where joueur.id = :joueurId")
                    .setParameter("joueurId", joueurId)
                    .list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return parties;
    }

    public List<Partie> findAll() {
        List<Partie> parties = null;
        try {
            session = openSession();
            parties = session.createQuery("from Partie").list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return parties;
    }

    public Partie create(Partie partie) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.persist(partie);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return partie;
    }

    public Partie update(Partie partie) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.merge(partie);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return partie;
    }

    public void delete(Partie partie) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.remove(partie);
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
