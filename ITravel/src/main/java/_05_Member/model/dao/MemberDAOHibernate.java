package _05_Member.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.*;

import _00_Misc.HibernateUtil_H4_Ver1;
import _05_Member.model.MemberVO;
import _05_Member.model.Member_interface;

public class MemberDAOHibernate implements Member_interface {

	private static final String GET_ALL_STMT = "from MemberVO order by memberId";

	MemberVO memberVO = null;

	@Override
	public MemberVO findByPrimaryKey(Integer memberId) {

		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			memberVO = (MemberVO) session.get(MemberVO.class, memberId);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}

		return memberVO;
	}

	@Override
	public void insert(MemberVO memberVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(memberVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction();
			throw e;
		}
	}

	@Override
	public void update(MemberVO memberVO) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(memberVO);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;

		}
	}

	@Override
	public void delete(Integer memberId) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();

		try {
			session.beginTransaction();
			MemberVO memberVO = new MemberVO();
			memberVO.setMemberId(memberId);
			session.delete(memberVO);
			session.getTransaction().commit();;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<MemberVO> getall() {
		List<MemberVO> list = null;
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

	public static void main(String[] args) {

		MemberDAOHibernate dao = new MemberDAOHibernate();
		// selectAll
		// List <MemberVO> list = dao.getall();
		// for(MemberVO aMember: list ){
		// System.out.println(aMember);
		// }

		// select
		// MemberVO res = dao.findByPrimaryKey(1);
		// System.out.println(res);

		// update
		// MemberVO res = dao.findByPrimaryKey(1);
		// res.setMemberAccount("a123456");
		// dao.update(res);
		// System.out.println(res);

		// insert
		// MemberVO res = dao.findByPrimaryKey(1);
		// dao.insert(res);
		// System.out.println(res);

		// delete
		 dao.delete(6);

	}

}
