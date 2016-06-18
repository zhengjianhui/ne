package action.cost;

import java.util.ArrayList;
import java.util.List;









import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import service.cost.Find;

import com.opensymphony.xwork2.ModelDriven;

import dao.CostDao;
import entity.Cost;
import entity.Page;
import action.SuperAction;

/**
 * 处理查看页面的请求
 * @author zjh
 *
 */
public class FindAction extends SuperAction implements ModelDriven<Cost>{
	
	private Cost cost = new Cost();
	private Integer size = 5;
	private Integer nowPage;
	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	


	/**
	 * 跳转查询页面
	 */
	public String find() {
		Find find = new Find();
		
		List<Cost> list = new ArrayList<Cost>();
		

		// 第一次登入
		if(nowPage == null) {
			nowPage = 1;
		}
		// 获取总共页数
		Integer page = find.page();
		if(page % size != 0) {
			page = page / size + 1;
		}
		
		// 计算从哪里显示
		int now = (nowPage - 1) * size;
		Page p = new Page();
		
		p.setSize(size);
		p.setNowPage(nowPage);
		p.setNow(now);
		p.setPage(page);
		
		request.setAttribute("pa", p);

		List<Cost> cost = find.sizeAndPage(p);
		request.setAttribute("cost", cost);
		
		return "find";
	}

	/**
	 * 跳转查询页面
	 * @return
	 */
	public String update() {
		Find f = new Find();
		cost = f.query(cost.getCostID());
		request.setAttribute("cost", cost);
		return "update";
	}
	
	/**
	 * 处理修改
	 */
	public String up() {
		
		
		return find();
	}

	public Cost getModel() {
		return cost;
	}
}
