package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/controller")
public class RestController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        User user = userService.searchUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<User> listUser(){
        List<User> list = userService.list();
        return list;
    }
}
