package _02_TripAndJournal.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _00_Misc.HibernateUtil_H4_Ver1;

public class MessageDAOHibernate {

	private static final String GET_ALL_MESSAGE = "from MessageVO order by message_id";

	public MessageVO selectmessageId(Integer messageId) {
		MessageVO messageVo = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			messageVo = (MessageVO) session.get(MessageVO.class, messageId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return messageVo;
	}

	public List<MessageVO> getAll() {
		List<MessageVO> list = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_MESSAGE);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public MessageVO update(MessageVO messageVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return messageVO;
	}

	public MessageVO insert(MessageVO messageVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(messageVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return messageVO;
	}
    public boolean delete(Integer messageId){
    	Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();	
			MessageVO messageVo = new MessageVO();
			messageVo.setMessageId(messageId);
			session.delete(messageVo);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
    	return false;
    }	

	public static void main(String[] args) {// 測試程式
		MessageDAOHibernate dao = new MessageDAOHibernate();
		// 查一筆↓
		// MessageVO selectone = dao.selectmessageId(1);
		// System.out.println(selectone);
		// 查多筆↓
		// List<MessageVO> list = dao.getAll();
		// System.out.println(list);
		// 更新
//		 MessageVO messageVo = dao.selectmessageId(1);
//		 messageVo.setMessageId(1);
//		 messageVo.setMemberId(1);
//		 messageVo.setMessageType("forum_type03");
//		 messageVo.setReferenceNo(4);
//		 messageVo.setContent("javatest11111");
//		 MessageVO updatetest = dao.update(messageVo);
//		 System.out.println(updatetest);
		// 新增
		// MessageVO messageVo = new MessageVO();
		// messageVo.setMemberId(1);
		// messageVo.setMessageType("forum_type04");
		// messageVo.setReferenceNo(4);
		// messageVo.setContent("javatest");
		// java.sql.Timestamp timestamp = new Timestamp( new
		// java.util.Date().getTime());
		// messageVo.setUpdateTime(timestamp);
		// MessageVO inserttest = dao.insert(messageVo);
		// System.out.println(inserttest);
		// 刪除
		// boolean delect = dao.delete(6);
		// System.out.println(delect);
	}
}
