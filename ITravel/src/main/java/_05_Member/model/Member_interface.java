package _05_Member.model;

import java.util.*;;

public interface Member_interface {
	public void insert(MemberVO vo);
	public void update(MemberVO vo);
	public void delete (Integer memberId);
	public MemberVO findByPrimaryKey(Integer memberId);
	public List<MemberVO> getall();
}
