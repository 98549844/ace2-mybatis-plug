package com.ace2.mybatisplug.controller;

import com.ace2.mybatisplug.generator.InsertUsers;
import com.ace2.mybatisplug.mapper.UsersMapper;
import com.ace2.mybatisplug.models.Users;
import com.ace2.mybatisplug.util.RandomUtil;
import com.ace2.mybatisplug.util.TypeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname: UserRestController
 * @Date: 5/7/2021 10:49 上午
 * @Author: garlam
 * @Description:
 */

@Controller
public class UsersController {
    private static final Logger log = LogManager.getLogger(UsersController.class.getName());

    private final UsersMapper usersMapper;

    @Autowired
    public UsersController(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public Users updateUserByMybatisPlus() {
        Users users;
        String acc = "garlam";
        int id = 533;
        log.info("select statement MUST NOT include common column !!!");
        users = usersMapper.selectByAccountWithoutCommonColumn(acc);

        Users u = usersMapper.selectById(533);
        log.info("before getVersion: " + u.getVersion());
        log.info("before getLastUpdateDate: " + u.getLastUpdateDate());
        log.info("before getLastUpdatedBy: " + u.getLastUpdatedBy());

        users.setMobile(TypeUtil.integerToString(RandomUtil.getRangeInt(0, 99999999)));
        usersMapper.updateById(users);

        users = usersMapper.selectById(id);

        log.info("after getVersion: " + users.getVersion());
        log.info("after getLastUpdateDate: " + users.getLastUpdateDate());
        log.info("after getLastUpdatedBy: " + users.getLastUpdatedBy());

        log.info("COMPLETE !!!");
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/insert")
    public Users insertUserByMybatisPlus() {
        List<Users> usersList = InsertUsers.insertUsers();
        usersMapper.insert(usersList.get(1));

        Users users = usersMapper.selectByAccount(usersList.get(1).getUserAccount());
        log.info("user: {}; id: {}", users.getUsername(), users.getUserId());
        log.info("after getVersion: " + users.getVersion());
        log.info("after getLastUpdateDate: " + users.getLastUpdateDate());
        log.info("after getLastUpdatedBy: " + users.getLastUpdatedBy());
        log.info("----------------------------");
        log.info("after getCreatedDate: " + users.getCreatedDate());
        log.info("after getCreatedBy: " + users.getCreatedBy());

        usersMapper.deleteById(users.getUserId());
        log.info("COMPLETE !!!");
        return users;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/findUserByMybatis/{acc}")
    public Users findUserByMybatis(@PathVariable String acc) {
        Users users = usersMapper.selectById(533);
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectAll")
    @ResponseBody
    public List<Users> selectAll() {

        List<Users> users1 = usersMapper.findAll();
        System.out.println("same mapper and xml : " + users1.size());

        List<Users> users2 = usersMapper.selectAll();
        System.out.println("not same mapper and xml : " + users2.size());
        return users1;
    }
}

