package cn.Service;

import cn.dao.UserRepository;
import cn.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImp  implements UserDetailsService {
    @Autowired
    private UserRepository dao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("验证用户名和密码");
        UserDetails userDetails=null;

        return userDetails;
    }
}
