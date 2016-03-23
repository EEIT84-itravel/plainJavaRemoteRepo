package _02_TripAndJournal.model.dao;

import java.util.List;

import hibernate.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

import _02_TripAndJournal.model.JournalDetailVO;

public class JournalDetailDAOHibernate {
	public static void main(String[] args) {
		JournalDetailDAOHibernate dao = new JournalDetailDAOHibernate();
		System.out.println(dao.select(1));
		// System.out.println(dao.delete(5));

		JournalDetailVO vo = new JournalDetailVO();
		// vo.setSightId(3);
		// vo.setJournalId(3);
		// vo.setSightOrder(3);
		// vo.setSightJournal("哈哈哈哈哈哈哈哈哈");
		// dao.insert(vo);

		

		List<JournalDetailVO> beans = dao.select();
		System.out.println(beans);

	}

	// 單筆查詢
	public JournalDetailVO select(Integer journalDetailId) {
		JournalDetailVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (JournalDetailVO) session.get(JournalDetailVO.class,
					journalDetailId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.beginTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	// 查全部
	public List<JournalDetailVO> select() {
		List<JournalDetailVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from JournalDetailVO");
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	// 修改資料
	public JournalDetailVO update(JournalDetailVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(vo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	// 新增資料
	public JournalDetailVO insert(JournalDetailVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	// 刪除資料
	public boolean delete(int journalDetailId) {
		if (this.select(journalDetailId) != null) {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			try {
				session.beginTransaction();
				JournalDetailVO vo = (JournalDetailVO) session.get(
						JournalDetailVO.class, journalDetailId);
				session.delete(vo);
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
			return true;
		} else {
			return false;
		}
	}

}
