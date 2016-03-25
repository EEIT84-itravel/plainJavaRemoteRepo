package _02_TripAndJournal.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _00_Misc.HibernateUtil_H4_Ver1;
import _02_TripAndJournal.model.TripCompanionVO;

public class TripCompanionDAOHibernate {

	public static void main(String[] args) {
		// TripCompanionDAOHibernate dao =new
		// TripCompanionDAOHibernate();//Select
		// TripCompanionVO bean = dao.select(3);
		// System.out.println(bean);

		// TripCompanionDAOHibernate dao = new
		// TripCompanionDAOHibernate();//Insert已存在Id 不要流水號
		// TripCompanionVO bean = new TripCompanionVO();
		// bean.setTripId(3);
		// bean.setMemberId(3);
		// dao.insert(bean);
		// System.out.println(bean);

		// TripCompanionDAOHibernate dao = new TripCompanionDAOHibernate();//
		// Update已存在Id 要流水號
		// TripCompanionVO bean = new TripCompanionVO();
		// bean.setCompanionId(21);
		// bean.setTripId(3);
		// bean.setMemberId(5);
		// dao.update(bean);
		// System.out.println(bean);

		// TripCompanionDAOHibernate dao = new
		// TripCompanionDAOHibernate();//Delete
		// boolean b = dao.delete(18);
		// System.out.println(b);

		// TripCompanionDAOHibernate dao = new TripCompanionDAOHibernate();//
		// Select All
		// List<TripCompanionVO> bean = dao.select();
		// for (int i = 0; i < bean.size(); i++) {
		// System.out.println(bean.get(i));
		// }
	}

	// select
	public TripCompanionVO select(Integer companionId) {
		TripCompanionVO tripCompanionVO = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			tripCompanionVO = (TripCompanionVO) session.get(
					TripCompanionVO.class, companionId);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return tripCompanionVO;
	}

	// insert
	public TripCompanionVO insert(TripCompanionVO tripCompanionVO) {

		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(tripCompanionVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return tripCompanionVO;
	}

	// update
	public TripCompanionVO update(TripCompanionVO tripCompanionVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(tripCompanionVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return tripCompanionVO;
	}

	// delete
	public boolean delete(Integer companionId) {
		boolean b = false;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TripCompanionVO tripCompanionVO = (TripCompanionVO) session.get(
					TripCompanionVO.class, companionId);
			session.delete(tripCompanionVO);
			session.getTransaction().commit();
			b = true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return b;
	}

	// select all
	public List<TripCompanionVO> select() {
		List<TripCompanionVO> list = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from TripCompanionVO");
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return list;
	}
}
