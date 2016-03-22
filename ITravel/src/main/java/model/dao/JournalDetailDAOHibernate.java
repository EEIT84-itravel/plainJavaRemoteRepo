package model.dao;

import java.util.List;

import hibernate.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

import model.JournalDetailVO;

public class JournalDetailDAOHibernate {
	private static final String SELECT_BY_ID = "select * from JournalDetailVO where journalDetailId=?";

	
	
	
	public JournalDetailVO select(Integer journalDetailId) {
		JournalDetailVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (JournalDetailVO)session.get(JournalDetailVO.class, journalDetailId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.beginTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	private static final String SELECT_ALL = "from JournalDetailVO order by journalDetailId";
	
	public List<JournalDetailVO> select() {
		List<JournalDetailVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			result = query.list();
			session.getTransaction().commit();	
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	private static final String UPDATE = "update journal_detail set journal_id=?, sight_id=?, view_order=?, view_journal=? where journal_detail_id=?";
	
	public JournalDetailVO update(Integer journalId, Integer sightId, Integer viewOrder, String viewJournal, Integer journalDetailId) {
		JournalDetailVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			vo = (JournalDetailVO)session.get(JournalDetailVO.class,journalDetailId);
			vo.setJournalId(journalId);
			vo.setSightId(sightId);
			vo.setViewOrder(viewOrder);
			vo.setViewJournal(viewJournal);
			 session.getTransaction().commit();  //必須commit才不會產生dirty reader
			 
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}
	
	private static final String INSERT = "insert into journal_detail (journal_detail_id, journal_id, sight_id, view_order, view_journal) values (?, ?, ?, ?, ?)";
	
	public JournalDetailVO insert(JournalDetailVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();			
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}
	private static final String DELETE = "delete from journal_detail where journal_detail_id=?";

	
	public boolean delete(Integer journalDetailId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			JournalDetailVO vo = (JournalDetailVO) session.get(JournalDetailVO.class, journalDetailId);
			session.delete(vo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return false;
	}	
	

}
