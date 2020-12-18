package cn.Service;

import cn.pojo.UserEntity;

public interface UserService {
    public UserEntity findByUsername(String userName);
}
