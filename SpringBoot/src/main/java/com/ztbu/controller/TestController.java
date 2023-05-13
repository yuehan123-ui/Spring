package com.ztbu.controller;

import com.ztbu.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    //接收简单参数
    @RequestMapping("/Test") //指定请求路径
    public String Test(String name, Integer age){
        System.out.println(name+age);
        return "ok";
    }
    //实体对象参数
    @RequestMapping("/TestPojo")
    public String TestPojo(User user){
        System.out.println(user);
        return "ok";
    }
    //数组参数
    @RequestMapping("/ArraysParam")
    public String ArraysParam(String [] arrays){
        System.out.println(Arrays.toString(arrays));
        return "ok";
    }
    //集合参数  (需要@RequestParm注解来映射集合  否则会默认为数组)
    @RequestMapping("/ListParam")
    public String ListParam(@RequestParam List<String> list){
        System.out.println(list);
        return "ok";
    }
    //接收时间参数并封装
    @RequestMapping("DataParam")
    public String DataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        //@DateTimeFormat注解 规定传入时间格式
        System.out.println(updateTime);
        return "ok";
    }

    //json参数
    //@RequestBody 注解将 json数据格式的数据封装到实体对象中
    //键名和属性名你保持一致
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }

    //特殊: 路径参数
    //@PathVariable  获取路径参数并绑定给形参
    @RequestMapping("/Path/{id}")
    public String lujingParam(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }
    //多个参数
    @RequestMapping("/Path/{id}/{name}")  //{id}  可变参数 不固定
    public String lujingsParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+name);
        return "ok";
    }
}
