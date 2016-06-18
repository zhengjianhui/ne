package action;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 所有Action的父类
 * @author zjh
 *
 */
@SuppressWarnings("serial")
public class SuperAction extends ActionSupport
	implements ServletContextAware,ServletRequestAware,ServletResponseAware {
	// 响应对象
	protected HttpServletResponse response;
	// 请求对象
	protected HttpServletRequest request;
	// 会话对象
	protected HttpSession session;
	// 全局对象
	protected ServletContext application;
	

	
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		session = request.getSession();
	}

	public void setServletContext(ServletContext arg0) {
		application = arg0;
	}

}
