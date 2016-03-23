package _02_TripAndJournal.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import _02_TripAndJournal.model.JournalPhotoVO;


public class JournalPhotoDAOHibernate {
	public static void main(String[] args) throws IOException{
		JournalPhotoDAOHibernate dao = new JournalPhotoDAOHibernate();
		JournalPhotoVO vo = new JournalPhotoVO();
//		System.out.println(dao.select(1));
		
		File imageFile = new File("src/main/webapp/images/cat.jpg");		
		InputStream is = new FileInputStream(imageFile);
		byte[] p = new byte[is.available()];
		is.read(p);
		is.close();
		vo.setJournalPhoto(p);
		vo.setJournalDetailId(4);
		System.out.println(dao.insert(vo));
		
		
	}
	
	public JournalPhotoVO select(Integer journalPhotoId){
		JournalPhotoVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (JournalPhotoVO) session.get(JournalPhotoVO.class, journalPhotoId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.beginTransaction().rollback();
		}
		return vo;
	}
	
	public List<JournalPhotoVO> select() {
		List<JournalPhotoVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from JournalPhotoVO");
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	
	// 修改資料
		public JournalPhotoVO update(JournalPhotoVO vo) {
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

		// 新增資料
		public JournalPhotoVO insert(JournalPhotoVO vo) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.save(vo);
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
			return vo;

		}

		// 刪除資料
		public boolean delete(Integer journalPhotoId) {
			if (this.select(journalPhotoId) != null) {
				Session session = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				try {
					session.beginTransaction();
					JournalPhotoVO vo = (JournalPhotoVO) session.get(JournalPhotoVO.class,
							journalPhotoId);
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
