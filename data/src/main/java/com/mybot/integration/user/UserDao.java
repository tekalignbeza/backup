package com.mybot.integration.user;

import com.mybot.domain.user.User;
import com.mybot.integration.base.GenericDao;


/**
 * Created by tekalign.bezawork on 4/22/16.
 */
public interface UserDao extends GenericDao<User>{

	public User findByUsername(String username);
}
