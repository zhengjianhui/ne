package service.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dbutil.ImageUtil;
import entity.Admin;

/**
 * 处理
 * @author zjh
 *
 */
public class Login {

	public Admin code(Admin admin) {
		// 传入dao层处理
		LoginDao dao = new LoginDao();
		// 结果结果集
		List<Admin> list = dao.login(admin);
		// 取出结果集
		if(list != null) {
			for(Admin a : list) {
				if(a.getCode().equals(admin.getCode())) {
					return admin = a;
				}
			} 
		} 
		return null;
	}
	
	public void img(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Object[] o = ImageUtil.createImage();
//		Login lo = new Login();
//		Object[] o = lo.img();
		
		// 将验证码存入
		session.setAttribute("imgAdmin", o[0]);
		
		// 将图片取出
		BufferedImage img = (BufferedImage)o[1];
		// 告诉浏览器我要输出什么
		response.setCharacterEncoding("image/png");
		
		// 获取一个输出流
		try {
			OutputStream out = response.getOutputStream();
			
			// 图片流  格式使用png java对png的格式支持比jpg好
			// 分别是 图片 图片格式 和输出流
			ImageIO.write(img, "png", out);
			// 关闭流
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
