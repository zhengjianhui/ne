package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dbutil.DBAccess;
import entity.Admin;

/**
 * 辅助登入
 * @author zjh
 *
 */
public class LoginDao {
	
	public List<Admin> login(Admin admin) {
		
		SqlSession sqlSession = null;
		List<Admin> a = new ArrayList<Admin>();
		try {
			sqlSession = DBAccess.getAccess();

			ILogin login = sqlSession.getMapper(ILogin.class);
			a = login.queryAdmin(admin); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		List<Admin> a = new ArrayList<Admin>();
		Admin admin = new Admin();
		admin.setCode("caocao");
		
		
		LoginDao dao = new LoginDao();
		a = dao.login(admin);
		System.out.println(a.get(0).getName());
		
	}
}
