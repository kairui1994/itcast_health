package com.xdsdjq.dao;

import com.xdsdjq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findByUsername(String username);

    List<User> selectByCondition(@Param("queryString") String queryString);

    void add(User user);

    User findById(Integer id);

    void edit(User user);

    void deleteById(Integer  id);

    void deleteRoleByUseId(Integer userId);
}
