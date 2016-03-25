package _05_Member.model;

import java.util.*;

public interface Collection_interface {
	public void insert(CollectionVO vo);
	public void update(CollectionVO vo);
	public void delete (Integer CollectionNo);
	public CollectionVO findByPrimaryKey(Integer CollectionNo);
	public List<CollectionVO> getall();
	
	
}
