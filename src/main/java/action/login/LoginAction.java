package action.login;



import service.login.Login;
import action.SuperAction;

import com.opensymphony.xwork2.ModelDriven;

import entity.Admin;

@SuppressWarnings("serial")
public class LoginAction extends SuperAction implements ModelDriven<Admin> {
	private Admin admin = new Admin();
	/**
	 * 跳转登入页面
	 * @return
	 */
	public String login() {
		return "login";
	}
	
	/**
	 * 图片验证码
	 */
	public String img() {
		Login lo = new Login();
		lo.img(request, response, session);
		return NONE;
	}
	
	/**
	 * 验证登入
	 * @return
	 */
	public String validation() {
		// 重构步骤将 admin 保存进request 中在交给Service层处理
		
		Login log = new Login();
		Admin a = log.code(admin);
		
		// 取出用户输入的验证码
		String vi = request.getParameter("vi");
		// 从session 中取出对应的验证码
		String imgAdmin = (String) session.getAttribute("imgAdmin");
		System.out.println(vi);
		System.out.println(imgAdmin);
		
		// 查看验证码是否正确
		if(vi == null || "".equals(vi) || !vi.equalsIgnoreCase(imgAdmin)) {
			request.setAttribute("error", "验证码错误");
			return "login";
		}
		
		// 如果账号为空
		if(!(a != null)) {
			request.setAttribute("error", "账号不存在");
			return "login";
		} else if(!a.getPassword().equals(admin.getPassword())) {
			request.setAttribute("error", "密码错误");
			return "login";
		}
		session.setAttribute("admin", a);
		return "indexAction";
	}

	/**
	 * 跳转主页
	 * @return
	 */
	public String index() {
		return "index";
	}

	public Admin getModel() {
		return admin;
	}


	
}
