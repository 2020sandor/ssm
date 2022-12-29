package com.itheima.service;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService  {
    List<User> getAll();
    User getById(Integer id);

    boolean save(User user);

    boolean update(User user);

    boolean delete(Integer id);
}
