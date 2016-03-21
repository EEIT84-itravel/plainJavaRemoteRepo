package _01_Sight.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import _00_Misc.CodeVO;

public class SightVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer sightId;
	private String sightName;
	private CodeVO regionId;
	private CodeVO countyId;
	private String sightTypeId;
	private String ticket;
	private Time openTime;
	private Time closeIime;
	private Time spendHour;
	private String layPeriod;		
	private Float score;
	private Float longitude;
	private Float latitude;
	private Integer watchNum;
	private Integer collectNum;
	private String phone;
	private String addr;
	private String trans;
	private Integer creator;
	private Timestamp createTime;
	private Integer modifier;
	private Timestamp modifyTime;
	private boolean del;
	
	public Integer getSightId() {
		return sightId;
	}
	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}
	public String getSightName() {
		return sightName;
	}
	public void setSightName(String sightName) {
		this.sightName = sightName;
	}
	public CodeVO getRegionId() {
		return regionId;
	}
	public void setRegionId(CodeVO regionId) {
		this.regionId = regionId;
	}
	public CodeVO getCountyId() {
		return countyId;
	}
	public void setCountyId(CodeVO countyId) {
		this.countyId = countyId;
	}
	public String getSightTypeId() {
		return sightTypeId;
	}
	public void setSightTypeId(String sightTypeId) {
		this.sightTypeId = sightTypeId;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Time getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}
	public Time getCloseIime() {
		return closeIime;
	}
	public void setCloseIime(Time closeIime) {
		this.closeIime = closeIime;
	}
	public Time getSpendHour() {
		return spendHour;
	}
	public void setSpendHour(Time spendHour) {
		this.spendHour = spendHour;
	}
	public String getLayPeriod() {
		return layPeriod;
	}
	public void setLayPeriod(String layPeriod) {
		this.layPeriod = layPeriod;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Integer getWatchNum() {
		return watchNum;
	}
	public void setWatchNum(Integer watchNum) {
		this.watchNum = watchNum;
	}
	public Integer getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getModifier() {
		return modifier;
	}
	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	
	
	
	
}
