package dao;

import java.util.List;

import entity.Admin;

/**
 * 声明一个接口
 * @author zjh
 *
 */
public interface ILogin {
	public List<Admin> queryAdmin(Admin admin);
}
