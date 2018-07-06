package com.styl.struts.restful;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;

public class UserController implements ModelDriven<Object> {

	private Long id;
	private User user = new User();
	private Object model;
	private UserDao userDao = new UserDaoImpl();

	public HttpHeaders index() {
		model = userDao.getAll();
		return new DefaultHttpHeaders("index");
	}

	public HttpHeaders create() {
		userDao.add(user);
		model = user;
		return new DefaultHttpHeaders("create");
	}

	public HttpHeaders update() {
		user.setId(id);
		userDao.update(user);
		model = user;
		return new DefaultHttpHeaders("update");
	}

	public HttpHeaders destroy() {
		userDao.delete(id);
		model = id;
		return new DefaultHttpHeaders("destroy");
	}

	public HttpHeaders show() {
		model = userDao.get(id);
		return new DefaultHttpHeaders("show");
	}

	public Object getModel() {
		return model;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
