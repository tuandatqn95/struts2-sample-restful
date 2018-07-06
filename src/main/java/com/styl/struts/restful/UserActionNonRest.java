package com.styl.struts.restful;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

public class UserActionNonRest implements Action, 
								ServletRequestAware {

	private User user = new User();
	private Long id;
	private Object data;
	private HttpServletRequest request;

	public String execute() throws Exception {
		UserDao userDao = new UserDaoImpl();
		if (request.getMethod().equals("GET")) {
			data = userDao.getAll();
			return SUCCESS;
		}
		return ERROR;
	}

	public String executeNonParam() {
		UserDao userDao = new UserDaoImpl();
		if (request.getMethod().equals("POST")) {
			userDao.add(user);
			return SUCCESS;
		}
		return ERROR;
	}

	public String executeWithParam() {
		UserDao userDao = new UserDaoImpl();

		if (request.getMethod().equals("GET")) {
			data = userDao.get(id);
			return SUCCESS;
		}
		return ERROR;
	}

	public Object getData() {
		return data;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
