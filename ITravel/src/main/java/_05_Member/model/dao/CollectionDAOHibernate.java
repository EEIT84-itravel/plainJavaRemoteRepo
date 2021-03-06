package _05_Member.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.*;

import _00_Misc.HibernateUtil_H4_Ver1;
import _05_Member.model.CollectionVO;

public class CollectionDAOHibernate {

	private static final String GET_ALL_STMT = "from  CollectionVO order by  collectionNo";

	CollectionVO collectionVO = null;

	public CollectionVO insert(CollectionVO collectionVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(collectionVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction();
			throw e;

		}
		return collectionVO;
	}

	public CollectionVO update(CollectionVO collectionVO) {

		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.update(collectionVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;

		}
		return collectionVO;

	}

	public Boolean delete(Integer CollectionNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			CollectionVO collectionVO = new CollectionVO();
			collectionVO.setCollectionNo(CollectionNo);
			session.delete(collectionVO);
			session.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			return false;
		}

	}

	public CollectionVO findByPrimaryKey(Integer CollectionNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			collectionVO = (CollectionVO) session.get(CollectionVO.class,
					CollectionNo);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return collectionVO;
	}

	public List<CollectionVO> getall() {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		List<CollectionVO> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return list;
	}

	public static void main(String[] args) {

		CollectionDAOHibernate dao = new CollectionDAOHibernate();
		// selectAll
		// List <CollectionVO> list = dao.getall();
		// for(CollectionVO aMember: list ){
		// System.out.println(aMember);
		// }

		// select
		// CollectionVO res = dao.findByPrimaryKey(1);
		// System.out.println(res);

		// update
		// CollectionVO res = dao.findByPrimaryKey(1);
		// res.setCollectionNo(1);
		// dao.update(res);
		// System.out.println(res);

		// insert
		// CollectionVO res = dao.findByPrimaryKey(1);
		// dao.insert(res);
		// System.out.println(res);

		// delete
		// dao.delete(5);
	}
}
