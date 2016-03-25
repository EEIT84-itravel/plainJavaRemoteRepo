package _05_Member.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.*;

import _00_Misc.HibernateUtil_H4_Ver1;
import _05_Member.model.CollectionVO;
import _05_Member.model.Collection_interface;
import _05_Member.model.MemberVO;

public class CollectionDAOHibernate implements  Collection_interface  {
	
	private static final String GET_ALL_STMT = "from  CollectionVO order by  collectionNo";
	
	CollectionVO collectionVO = null; 
	
	@Override
	public void insert(CollectionVO vo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
	
		try {
			session.beginTransaction();
			session.saveOrUpdate(collectionVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction();
			throw e;
			
		}
	}

	@Override
	public void update(CollectionVO vo) {
		
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(collectionVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
			
		}
		
		
		
	}

	@Override
	public void delete(Integer CollectionNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			CollectionVO collectionVO = new CollectionVO();
			collectionVO.setCollectionNo(CollectionNo);
			session.delete(collectionVO);
			session.getTransaction();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;	
		}
		
	}

	@Override
	public CollectionVO findByPrimaryKey(Integer CollectionNo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			collectionVO = (CollectionVO) session.get(CollectionVO.class, CollectionNo);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		
		return collectionVO;
	}

	@Override
	public List<CollectionVO> getall() {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
		
		List<CollectionVO> list = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list  = query.list();
			session.getTransaction();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return list;
	}
	
	
	
		public static void main (String [] args) {
		
		CollectionDAOHibernate dao = new CollectionDAOHibernate();
		
		List <CollectionVO> list = dao.getall();
		
		for(CollectionVO aCollection: list ){
			System.out.println(aCollection.getCollectionNo()+",");
			System.out.println(aCollection.getMemberId()+",");
			System.out.println(aCollection.getTypeId()+",");
			System.out.println(aCollection.getReferenceType()+",");
		}
}
}
