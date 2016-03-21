package _01_Sight.model.dao;

import org.hibernate.Session;

import _00_Misc.HibernateUtil_H4_Ver1;
import _01_Sight.model.SightVO;

public class SightDAOHibernate {
	
	public static void main(String[] args) {
		SightDAOHibernate dao = new SightDAOHibernate();
		SightVO sightVO = dao.findByPrimaryKey(1);
		System.out.println(sightVO);
	}
	
	public SightVO findByPrimaryKey(Integer sightId) {
		SightVO sightVO = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			sightVO = (SightVO) session.get(SightVO.class, sightId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return sightVO;
	}

}
