package com.xefi.englishtest.dao;

import com.xefi.englishtest.pojos.Question;
import org.hibernate.Transaction;
import java.util.List;

public class QuestionDao extends Dao {

    public Question findById(Long id) {
        Question question = null;
        try {
            session = openSession();
            question = (Question)session.get(Question.class, id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return question;
    }

    public List<Question> findByPartieId(Long partieId) {
        List<Question> questions = null;
        try {
            session = openSession();
            questions = session.createQuery("from Question where partie.id = :partieId")
                    .setParameter("partieId", partieId)
                    .list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return questions;
    }

    public List<Question> findAll() {
        List<Question> questions = null;
        try {
            session = openSession();
            questions = session.createQuery("from Question").list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }
        return questions;
    }

    public Question create(Question question) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.persist(question);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return question;
    }

    public Question update(Question question) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.merge(question);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            closeSession();
        }
        return question;
    }

    public void delete(Question question) {
        Transaction transaction = null;
        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.remove(question);
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