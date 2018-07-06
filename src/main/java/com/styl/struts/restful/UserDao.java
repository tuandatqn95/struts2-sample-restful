package com.styl.struts.restful;

import java.util.List;

public interface UserDao {
	
	void add(User user);
	
	List<User> getAll();
	
	User get(long id);
	
	void update(User user);
	
	void delete(long id);
}
