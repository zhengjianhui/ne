package dbutil;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Admin;



/**
 * 用于获取数据连接框架 mybatis的实例
 * @author zjh
 *
 */
public class DBAccess {

	public static SqlSession getAccess() throws IOException {
		// 读取XML文件
		Reader reader = Resources.getResourceAsReader("config/Configuration.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	
	public static void main(String[] args) {
		SqlSession sess = null;
		try {
			sess = new DBAccess().getAccess();
			
			Admin aa = new Admin();
			aa.setCode("caocao");
			
			List<Admin> a = new ArrayList<Admin>();
			a = sess.selectList("admin.queryAdmin",aa);
			
			System.out.println(a.get(0).getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
}
