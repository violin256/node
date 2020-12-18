package cn.Service;

import cn.dao.UserRepository;
import cn.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public MyUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    //设置加密算法
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        //获取数据库中的用户信息
        UserEntity userEntity=userRepository.findByUserName(username).orElseGet(()->{
            System.out.println("userDetails");
            return new UserEntity();
        });
            List<GrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));//添加权限

            return new User(
                    userEntity.getUserName(),
                    passwordEncoder().encode(userEntity.getPassword()),
                    authorities);


    }
}
