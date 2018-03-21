package com.lqpl66.mapper;

import com.lqpl66.bean.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}