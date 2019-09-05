package com.zzus.blog.mapper;


import com.zzus.blog.bean.db.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserFromDatabase(@Param("username") String username);

}
