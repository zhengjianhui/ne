package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dbutil.DBAccess;
import entity.Cost;
import entity.Page;

/**
 * 处理cost表
 * @author zjh
 *
 */
public class CostDao {
	
	
	
	/**
	 * 分页页数
	 */
	public int page() {
		int page = 0;
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = DBAccess.getAccess();
			
			ICost cost = sqlSession.getMapper(ICost.class);
			Integer ss = cost.page();
			if(ss != null) {
				page = ss;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return page;
	}
	
	/**
	 * 分页
	 * @param args
	 */
	public List<Cost> sizeAndPage(Page p) {
		List<Cost> list = new ArrayList<Cost>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = DBAccess.getAccess();

			
			ICost cost = sqlSession.getMapper(ICost.class);
			list = cost.sizeAndPage(p);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	/**
	 * 单个查询
	 * @param costID
	 * @return
	 */
	public Cost query(Integer costID) {
		SqlSession sqlSession = null;
		Cost c = new Cost();
		c.setCostID(costID);
		try {
		
			sqlSession = DBAccess.getAccess();
			ICost icost = sqlSession.getMapper(ICost.class);
			c = icost.queryCost(c);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	
	
	public static void main(String[] args) {
		CostDao dao = new CostDao();
		Cost c = dao.query(4);
		System.out.println(c.getName());
		
	}
}
