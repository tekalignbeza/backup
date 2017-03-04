package com.mybot.integration.user;

import com.mybot.domain.user.User;
import com.mybot.integration.base.GenericDaoImp;

import org.springframework.stereotype.Repository;

/**
 * Created by tekalign.bezawork on 4/22/16.
 */

@Repository
public class UserDaoImp extends GenericDaoImp<User> implements UserDao{

    public UserDaoImp() {
        super(User.class);
    }
    
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return super.get(username);
	}
}
