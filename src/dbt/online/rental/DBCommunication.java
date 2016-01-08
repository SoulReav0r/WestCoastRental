package dbt.online.rental;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBCommunication<T> {
		
	void execute(T c, METHOD method) {
		Transaction tx = null;
		Session session = InitSessionFactory.getInstance().getCurrentSession();
		try {
			tx = session.beginTransaction();
			switch(method){
				case CREATE: session.save(c);
					break;
				case DELETE: session.delete(c);
					break;
				case UPDATE: session.update(c);
					break;	
			}
			session.save(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		}
	}	
    
    public enum METHOD{
    	CREATE,
    	UPDATE,
    	DELETE
    }
}
