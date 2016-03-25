package _05_Member.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.*;

import _00_Misc.HibernateUtil_H4_Ver1;
import _05_Member.model.CollectionVO;
import _05_Member.model.Friend_interface;
import _05_Member.model.MemberVO;
import _05_Member.model.TrackVO;
import _05_Member.model.Track_interface;

public class TrackDAOHibernate implements Track_interface {

	private static final String GET_ALL_STMT = "from  TrackVO order by  trackNo";

	TrackVO trackVO = null;

	@Override
	public void insert(TrackVO trackVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(trackVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction();
			throw e;
		}
	}

	@Override
	public void update(TrackVO trackVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(trackVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void delete(Integer trackNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			TrackVO tracknVO = new TrackVO();
			tracknVO.setTrackNo(trackNo);
			session.delete(tracknVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public TrackVO findByPrimaryKey(Integer TrackNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			trackVO = (TrackVO) session.get(TrackVO.class, TrackNo);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return trackVO;
	}

	@Override
	public List<TrackVO> getall() {

		List<TrackVO> list = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
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

	public static void main(String[] ages) {
		TrackDAOHibernate dao = new TrackDAOHibernate();

		// selectAll
		// List <TrackVO> list = dao.getall();
		// for(TrackVO aMember: list ){
		// System.out.println(aMember);
		// }

		// select
		// TrackVO res = dao.findByPrimaryKey(1);
		// System.out.println(res);

		// update
		// TrackVO res = dao.findByPrimaryKey(1);
		// res.setMemberId(1);
		// dao.update(res);
		// System.out.println(res);

		// insert
		// TrackVO res = dao.findByPrimaryKey(1);
		// dao.insert(res);
		// System.out.println(res);

		// delete
		 dao.delete(6);

	}

}
