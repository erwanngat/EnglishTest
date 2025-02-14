package com.xefi.englishtest.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    private HibernateUtil() {
    }
    public static synchronized SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            System.setProperty("org.sqlite.tmpdir", "C:\\Users\\Nicolas\\AppData\\Local\\Temp");
            sessionFactory = new
                    Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return sessionFactory;
    }
}