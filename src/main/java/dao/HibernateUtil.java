package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory ourSessionFactory;

    private HibernateUtil() {
    }

    public static Session getSession() throws HibernateException {
        if (ourSessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                ourSessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return ourSessionFactory.openSession();
    }
}
