package com.mybot.application.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybot.application.base.GenericServiceImp;
import com.mybot.application.email.EmailSender;
import com.mybot.domain.user.User;
import com.mybot.integration.user.UserDao;

/**
 * Created by tekalign.bezawork on 12/22/16.
 */
@Service
public class UserServiceImp extends GenericServiceImp<User> implements UserService {

    UserDao userDao;
    @Autowired
    EmailSender emailSender;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        super(userDao);
    }
    
    @Override
    public User create(User entity){
        User created = super.create(entity);
        emailSender.send(created.getEmail());
        return created;
    }
    
}
