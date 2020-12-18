package cn.config;

import cn.Service.MyUserService;
import cn.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository  userRepository;

    //配置拦截路径和跳转路径

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/index")
                .permitAll()//所有人可以访问
                .anyRequest()//对于任何请求进行拦截
                .authenticated();//启动认证
        http.formLogin()
                .loginPage("/test")//自定义登录页面
                .loginProcessingUrl("/login")//跳转到默认的controller
                .permitAll()
                .successForwardUrl("/main")
                .failureForwardUrl("/error");

    }




    //把配置自定义的用户服务写到configure配置里
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new MyUserService(userRepository));
    }

}
