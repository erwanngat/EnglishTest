package com.xefi.englishtest.dao;

import com.xefi.englishtest.pojos.Member;
import com.xefi.englishtest.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MemberDao {
    private Session session;
    /**
     * Méthode permettant de récupérer un member suivant son id
     * @return Un Member
     */
    public Member findById(Long id) {
        Member member = null;
        try {
            session = openSession();
            member = (Member) session.get(Member.class, id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return member;
    }
    /**
     * Méthode permettant de récupérer la liste des members
     * @return La liste des members
     */
    public List<Member> findAll() {
        List<Member> members = null;
        try {
            session = openSession();
            members = session.createQuery("from Member").list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return members;
    }
    /**
     * Méthode permettant de créer un member
     * @return Member créé avec le nouvel id
     */
    public Member create(Member member) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.persist(member);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return member;
    }
    /**
     * Méthode permettant de mettre à jour un member
     * @return Member mis à jour
     */
    public Member update(Member member) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.merge(member);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return member;
    }
    /**
     * Méthode permettant de supprimer un member
     * @return void
     */
    public void delete(Member member) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.remove(member);
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
    /**
     * Méthode permettant de créer une session Hibernate
     * @return Un objet Session
     */
    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
    /**
     * Méthode permettant de fermer une session Hibernate
     * @return void
     */
    private void closeSession() {
        session.close();
    }
}
