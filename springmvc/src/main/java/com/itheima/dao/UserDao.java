package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select("select* from t_users")
    List<User> getAll();

    @Select("select * from t_users where id = #{id}")
    User getById(Integer id);

    @Insert("insert into t_users (username,password) values(#{username},#{password})")
    boolean save(User user);

    @Update("update t_users set username = #{username}, password = #{password} where id = #{id}")
    boolean update(User user);

    @Delete("delete from t_users where id = #{id}")
    boolean delete(Integer id);
}
