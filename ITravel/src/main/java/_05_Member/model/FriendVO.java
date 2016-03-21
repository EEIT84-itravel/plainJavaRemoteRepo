package _05_Member.model;

import java.io.Serializable;

public class FriendVO implements Serializable {
	private Integer friendNo;//編號
	private Integer memberId;//會員編號
	private Integer firendId;//好友會員編號
	@Override
	public String toString() {
		return "FriendVO [friendNo=" + friendNo + ", memberId=" + memberId
				+ ", firendId=" + firendId + "]";
	}
	public Integer getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(Integer friendNo) {
		this.friendNo = friendNo;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getFirendId() {
		return firendId;
	}
	public void setFirendId(Integer firendId) {
		this.firendId = firendId;
	}
	
	
}
