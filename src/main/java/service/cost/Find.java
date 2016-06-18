package service.cost;

import java.util.ArrayList;
import java.util.List;


import dao.CostDao;
import entity.Cost;
import entity.Page;

/**
 * 处理cost页面业务
 * @author zjh
 *
 */
public class Find {
	
	/**
	 * 获取分页
	 * @return
	 */
	public int page() {
		
		CostDao dao = new CostDao();
		int page = dao.page();
		return page;
	}
	
	/**
	 * 提供分页数据
	 * @param p
	 * @return
	 */
	public List<Cost> sizeAndPage(Page p) {

		List<Cost> list = new ArrayList<Cost>();
		
		CostDao dao = new CostDao();

		
		list = dao.sizeAndPage(p);
		
		return list;
	}
	
	public Cost query(Integer id) {
		
		CostDao dao = new CostDao();
		Cost c = dao.query(id);
		return c;
	}
	
}
