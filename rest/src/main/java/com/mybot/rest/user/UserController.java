package com.mybot.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mybot.domain.user.User;
import com.mybot.rest.base.GenericController;
import com.mybot.application.user.UserService;


@Controller
@RequestMapping(value = "/user")
public class UserController extends GenericController<User> {
    @Autowired
    public UserController(UserService memberService) {
        super(memberService);
    }
}
