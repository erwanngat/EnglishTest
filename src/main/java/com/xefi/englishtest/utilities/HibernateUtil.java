package com.xefi.englishtest.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    private HibernateUtil() {
    }
    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new
                    Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return sessionFactory;
    }
}