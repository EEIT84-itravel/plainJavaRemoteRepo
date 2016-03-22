package model;

import java.io.Serializable;

public class JournalDetailVO implements Serializable{  //遊記明細
	
	private Integer journalDetailId; //遊記明細編號
	private Integer journalId; //遊記編號
	private Integer sightId; //景點編號
	private Integer viewOrder; //景點順序
	private String viewJournal; //景點的遊記
	
	
	@Override
	public String toString() {
		return "JournalDetailVO [journalDetailId=" + journalDetailId
				+ ", journalId=" + journalId + ", sightId=" + sightId
				+ ", viewOrder=" + viewOrder + ", viewJournal=" + viewJournal
				+ "]";
	}
	public Integer getJournalDetailId() {
		return journalDetailId;
	}
	public void setJournalDetailId(Integer journalDetailId) {
		this.journalDetailId = journalDetailId;
	}
	public Integer getJournalId() {
		return journalId;
	}
	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
	public Integer getSightId() {
		return sightId;
	}
	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}
	public Integer getViewOrder() {
		return viewOrder;
	}
	public void setViewOrder(Integer viewOrder) {
		this.viewOrder = viewOrder;
	}
	public String getViewJournal() {
		return viewJournal;
	}
	public void setViewJournal(String viewJournal) {
		this.viewJournal = viewJournal;
	}

	
}
