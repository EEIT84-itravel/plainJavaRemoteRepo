package _05_Member.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.*;

import _00_Misc.HibernateUtil_H4_Ver1;
import _05_Member.model.CollectionVO;
import _05_Member.model.FriendVO;
import _05_Member.model.Friend_interface;
import _05_Member.model.MemberVO;

public class FriendDAOHibernate implements Friend_interface {

	private static final String GET_ALL_STMT = "from  FriendVO order by  friendNo";

	FriendVO friendVO = null;

	@Override
	public void insert(FriendVO vo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(friendVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction();
			throw e;

		}

	}

	@Override
	public void update(FriendVO vo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(friendVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;

		}
	}

	@Override
	public void delete(Integer FriendNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			FriendVO friendVO = new FriendVO();
			friendVO.setFriendNo(FriendNo);
			session.delete(friendVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public FriendVO findByPrimaryKey(Integer FriendNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			friendVO = (FriendVO) session.get(FriendVO.class, FriendNo);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return friendVO;
	}

	@Override
	public List<FriendVO> getall() {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		List<FriendVO> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return list;

	}

	public static void main(String[] args) {

		FriendDAOHibernate dao = new FriendDAOHibernate();
		// selectAll
		// List <FriendVO> list = dao.getall();
		// for(FriendVO aMember: list ){
		// System.out.println(aMember);
		// }

		// select
//		FriendVO res = dao.findByPrimaryKey(1);
//		System.out.println(res);

		// update
//		 FriendVO res = dao.findByPrimaryKey(1);
//		 res.setFriendId(3);
//		 dao.update(res);
//		 System.out.println(res);

		// insert
//		 FriendVO res = dao.findByPrimaryKey(1);
//		 dao.insert(res);
//		 FriendVO res1 = dao.findByPrimaryKey(4);
//		 System.out.println(res1);

		 //delete
		 dao.delete(4);
	}
}