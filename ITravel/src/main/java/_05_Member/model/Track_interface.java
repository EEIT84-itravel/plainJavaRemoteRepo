package _05_Member.model;

import java.util.*;

public interface Track_interface {
	public void insert(TrackVO vo);
	public void update(TrackVO vo);
	public void delete (Integer TracknNo);
	public MemberVO findByPrimaryKey(Integer TrackNo);
	public List<TrackVO> getall();
	
	
}
