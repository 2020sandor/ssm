package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getById(Integer id) {
        return userDao.getById(id);
    }
    public boolean save(User user){
        return userDao.save(user);
    }

    public boolean update(User user){
        return userDao.update(user);
    }

    public boolean delete(Integer id){
        return userDao.delete(id);
    }

}
