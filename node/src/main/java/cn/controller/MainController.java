package cn.controller;

import cn.Service.PetService;
import cn.pojo.PetsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PetService petService;
    @RequestMapping("/main")
    public String toMain(){
        return "redirect:main/0";
    }
    @RequestMapping("/test")
    public String toTest(){
        return "test";
    }

    //Model:spring的模型视图接口
    @GetMapping("/main/{page}")
    public String turnPage(
            @PathVariable int page
            , @RequestParam(name = "size" ,defaultValue = "5") int size
            , Model model){
        System.out.println("page:"+page);
        Page<PetsEntity> infos=petService.findAll(page, size);
        model.addAttribute("info",infos.getContent());
        model.addAttribute("totalPages",infos.getTotalPages());
        model.addAttribute("page",infos.getNumber());
        System.out.println("内容："+infos.getContent());

        return "main";
    }


}
