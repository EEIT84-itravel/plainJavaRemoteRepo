package _02_TripAndJournal.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _00_Misc.HibernateUtil_H4_Ver1;

public class ReportDAOHibernate {

	private static final String GET_ALL_Report = "from ReportVO order by report_id";

	public ReportVO selectreportId(Integer reportId) {
		ReportVO reportVo = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			reportVo = (ReportVO) session.get(ReportVO.class, reportId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reportVo;
	}

	public List<ReportVO> getAll() {
		List<ReportVO> list = null;
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_Report);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public ReportVO update(ReportVO reportVo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(reportVo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reportVo;
	}

	public ReportVO insert(ReportVO reportVo) {
		Session session = HibernateUtil_H4_Ver1.getSessionFactory()
				.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(reportVo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reportVo;
	}
	 public boolean delete(Integer reportId){
	    	Session session = HibernateUtil_H4_Ver1.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();	
				ReportVO reportVo = new ReportVO();
				reportVo.setReportId(reportId);
				session.delete(reportVo);
				session.getTransaction().commit();
				return true;
			} catch (Exception ex) {
				session.getTransaction().rollback();
				ex.printStackTrace();
			}
	    	return false;
	    }	

	public static void main(String[] args) {// 測試程式
		ReportDAOHibernate dao = new ReportDAOHibernate();
		// 查一筆↓
		// ReportVO selectone = dao.selectreportId(1);
		// System.out.println(selectone);
		// 查多筆↓
		// List<ReportVO> list = dao.getAll();
		// System.out.println(list);
		// 更新
		// ReportVO reportVo= new ReportVO(); //錯誤的
		// ReportVO reportVo = dao.selectreportId(1);
		// reportVo.setReportId(1);
		// reportVo.setReferenceType("type_id05");
		// reportVo.setReferenceNo(4);
		// reportVo.setReporter(4);
		// reportVo.setReportType("report_type04");
		// ReportVO updatetest = dao.update(reportVo);
		// System.out.println(updatetest);
		// 新增
		// ReportVO reportVo= new ReportVO();
		// reportVo.setReportId(1);
		// reportVo.setReferenceType("type_id05");
		// reportVo.setReferenceNo(4);
		// reportVo.setReporter(4);
		// java.sql.Timestamp timestamp = new Timestamp( new
		// java.util.Date().getTime());
		// reportVo.setReportTime(timestamp);
		// reportVo.setProsecutor(3);
		// reportVo.setProcessStatusId("process_status05");
		// reportVo.setReportType("report_type06");
		// ReportVO inserttest = dao.insert(reportVo);
		// System.out.println(inserttest);
		// 刪除
		// boolean delect = dao.delete(6);
		// System.out.println(delect);
	}

}
