package _02_TripAndJournal.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _00_Misc.HibernateUtil_H4_Ver1;
import _02_TripAndJournal.model.TransVO;

public class TransDAOHibernate {

	public static void main(String[] args) {
		TransDAOHibernate dao = new TransDAOHibernate();
		// select
		// TransVO res = dao.select(1);
		// System.out.println(res);

		// selectAll
		// List<TransVO> codes = dao.select();
		// for (TransVO detail : codes) {
		// System.out.println(detail);
		// }

		// update
		// TransVO transVO = dao.update(6,"trans_form02");
		// System.out.println(transVO);

		// insert
		// TransVO t1 = new TransVO();
		// t1.setTransFormId("trans_form01");
		// TransVO transVO = dao.insert(t1);
		// System.out.println(transVO);

		// delete
		// System.out.println(dao.delete(6));

	}

	public TransVO insert(TransVO transVO) {
		Session session = null;
		try {
			session = HibernateUtil_H4_Ver1.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(transVO);
			session.getTransaction().commit();
			return transVO;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public TransVO update(Integer transId, String transFormId) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session = HibernateUtil_H4_Ver1.getSessionFactory().openSession();
			session.beginTransaction();
			TransVO transVO = (TransVO) session.get(TransVO.class, transId);
			if (transVO != null) {
				transVO.setTransFormId(transFormId);
			}
			session.getTransaction().commit();
			return transVO;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public TransVO select(Integer transId) {
		TransVO transVO = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			transVO = (TransVO) session.get(TransVO.class, transId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return transVO;
	}

	private static final String GET_ALL_STMT = "from TransVO order by transId";

	public List<TransVO> select() {
		List<TransVO> list = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public boolean delete(Integer transId) {
		Session session = null;
		session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session
				.createQuery("delete from TransVO where transId=?");
		query.setParameter(0, transId);
		int delete = query.executeUpdate();
		if (delete != 0) {
			session.getTransaction().commit();
			return true;
		} else {
			session.getTransaction().rollback();
			return false;
		}
	}

}
