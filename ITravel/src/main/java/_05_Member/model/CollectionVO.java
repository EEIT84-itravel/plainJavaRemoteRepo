package _05_Member.model;

import java.io.Serializable;

public class CollectionVO implements Serializable {
	private Integer collectionNo;//會員收藏編號
	private Integer memberId;//會員編號
	private String typeId;//類型
	private Integer reference_type;//參照編號
	@Override
	public String toString() {
		return "CollectionVO [collectionNo=" + collectionNo + ", memberId="
				+ memberId + ", typeId=" + typeId + ", reference_type="
				+ reference_type + "]";
	}
	public Integer getCollectionNo() {
		return collectionNo;
	}
	public void setCollectionNo(Integer collectionNo) {
		this.collectionNo = collectionNo;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public Integer getReference_type() {
		return reference_type;
	}
	public void setReference_type(Integer reference_type) {
		this.reference_type = reference_type;
	}
	
}
