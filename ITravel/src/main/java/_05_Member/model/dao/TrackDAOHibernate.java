package _05_Member.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.*;

import _00_Misc.HibernateUtil_H4_Ver1;
import _05_Member.model.Friend_interface;
import _05_Member.model.MemberVO;
import _05_Member.model.TrackVO;
import _05_Member.model.Track_interface;

public class TrackDAOHibernate implements Track_interface{

	private static final String GET_ALL_STMT = "from  TrackVO order by  trackNo";
	
	TrackVO trackVO = null;
	
	@Override
	public void insert(TrackVO vo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(trackVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction();
			throw e;
		}	
	}

	@Override
	public void update(TrackVO vo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();

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
	public void delete(Integer TracknNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()	.getCurrentSession();

		try {
			session.beginTransaction();
			TrackVO tracknVO = new TrackVO();
			tracknVO.settrackNo(trackNo);
			session.delete(tracknVO);
			session.getTransaction();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}

		
	}

	@Override
	public TracknVO findByPrimaryKey(Integer TrackNo) {
		
		return null;
	}

	@Override
	public List<TrackVO> getall() {
		
		return null;
	}

}
