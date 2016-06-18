package dao;

import java.util.List;

import entity.Cost;
import entity.Page;

public interface ICost {
	// 查询总页数
	public Integer page();
	// 查询分页记录
	public List<Cost> sizeAndPage(Page page);
	// 根据id查询
	public Cost queryCost(Cost c);
	
}
