package com.xefi.englishtest.dao;

import com.xefi.englishtest.pojos.Verbe;
import org.hibernate.Transaction;
import java.util.List;

public class VerbeDao extends Dao {

    public Verbe findById(Long id) {
        Verbe verbe = null;
        try {
            session = openSession();
            verbe = (Verbe)session.get(Verbe.class, id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return verbe;
    }

    public List<Verbe> findAll() {
        List<Verbe> verbes = null;
        try {
            session = openSession();
            verbes = session.createQuery("from Verbe").list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return verbes;
    }

    public Verbe create(Verbe verbe) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.persist(verbe);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return verbe;
    }

    public Verbe update(Verbe verbe) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.merge(verbe);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return verbe;
    }

    public void delete(Verbe verbe) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.remove(verbe);
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
