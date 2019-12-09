package com.hotel.controller;

import com.hotel.dao.UserRepository;
import com.hotel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/8/21 0021.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public User findById(@PathVariable(value = "id") Long id, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        User oneUser=this.userRepository.getOne(id);
        return oneUser;
    }
}
