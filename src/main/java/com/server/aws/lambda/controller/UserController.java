package com.server.aws.lambda.controller;

import com.server.aws.lambda.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> listLambdaUsers() {
        return Arrays.asList(new User("John", 20), new User("Mike", 25));
    }
}
