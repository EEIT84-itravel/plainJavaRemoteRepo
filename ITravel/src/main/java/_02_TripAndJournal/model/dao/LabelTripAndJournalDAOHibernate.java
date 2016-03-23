package _02_TripAndJournal.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _00_Misc.HibernateUtil_H4_Ver1;
import _02_TripAndJournal.model.LabelTripAndJournalVO;

public class LabelTripAndJournalDAOHibernate {
	public static void main(String[] args) {
		LabelTripAndJournalDAOHibernate dao = new LabelTripAndJournalDAOHibernate();
		// select
		// LabelTripAndJournalVO res = dao.select(1);
		// System.out.println(res);

		// selectAll
		// List<LabelTripAndJournalVO> codes = dao.select();
		// for (LabelTripAndJournalVO detail : codes) {
		// System.out.println(detail);
		// }

		// update
		// LabelTripAndJournalVO labelTripAndJournalVO = dao.update(7,
		// "type_id03", 1, "label02");
		// System.out.println(labelTripAndJournalVO);

		// insert
		// LabelTripAndJournalVO l1 = new LabelTripAndJournalVO();
		// l1.setReferenceType("type_id03"); // 類型:遊記
		// l1.setReferenceNo(1);
		// l1.setLabelId("label01"); // 標籤:春
		// LabelTripAndJournalVO labelTripAndJournalVO = dao.insert(l1);
		// System.out.println(labelTripAndJournalVO);

		// delete
		// System.out.println(dao.delete(6));

	}

	public LabelTripAndJournalVO insert(
			LabelTripAndJournalVO labelTripAndJournalVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(labelTripAndJournalVO);
			session.getTransaction().commit();
			return labelTripAndJournalVO;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public LabelTripAndJournalVO update(Integer labelDetailId,
			String referenceType, Integer referenceNo, String labelId) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			LabelTripAndJournalVO labelTripAndJournalVO = (LabelTripAndJournalVO) session
					.get(LabelTripAndJournalVO.class, labelDetailId);
			if (labelTripAndJournalVO != null) {
				labelTripAndJournalVO.setReferenceType(referenceType);
				labelTripAndJournalVO.setReferenceNo(referenceNo);
				labelTripAndJournalVO.setLabelId(labelId);
			}
			session.getTransaction().commit();
			return labelTripAndJournalVO;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public LabelTripAndJournalVO select(Integer labelDetailId) {
		LabelTripAndJournalVO labelTripAndJournalVO = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			labelTripAndJournalVO = (LabelTripAndJournalVO) session.get(
					LabelTripAndJournalVO.class, labelDetailId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return labelTripAndJournalVO;
	}

	private static final String GET_ALL_STMT = "from LabelTripAndJournalVO order by labelDetailId";

	public List<LabelTripAndJournalVO> select() {
		List<LabelTripAndJournalVO> list = null;
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

	public boolean delete(Integer labelDetailId) {
		Session session = null;
		session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session
				.createQuery("delete from LabelTripAndJournalVO where labelDetailId=?");
		query.setParameter(0, labelDetailId);
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
