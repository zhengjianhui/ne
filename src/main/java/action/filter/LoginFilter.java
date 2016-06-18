package action.filter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import entity.Admin;

@SuppressWarnings("serial")
public class LoginFilter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取Context对象
		ActionContext context = invocation.getInvocationContext();
		// 获取Session
		Map<String,Object> session = context.getSession();
		
		Admin a  = (Admin) session.get("admin");
		System.out.println(a.getCode());
		
		
		return null;
	}

}
