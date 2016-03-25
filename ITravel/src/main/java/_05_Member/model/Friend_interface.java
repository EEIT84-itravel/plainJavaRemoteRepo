package _05_Member.model;

import java.util.*;

public interface Friend_interface {
	public void insert(FriendVO vo);
	public void update(FriendVO vo);
	public void delete (Integer FriendNo);
	public MemberVO findByPrimaryKey(Integer FriendNo);
	public List<FriendVO> getall();
	
	
}
