package cn.controller;

import cn.pojo.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @RequestMapping("/")
    public String toIndex1(){
        System.out.println("登录");
        return "index";
    }

//    @PostMapping("/login")
//    public String toLogin(
//            @RequestBody UserEntity userEntity){
//        System.out.println("登录2"+userEntity);
//        return "redirect:/main";
//    }
//    @RequestMapping("/error")
//    public String toError(){
//        return "error";
//    }
}
