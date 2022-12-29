package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//使用“@Controller”定义bean
//@Controller
@RestController
@RequestMapping("/users")
public class UserController {
    //    //设置访问路径
//    @RequestMapping("/save")
//    //设置当前操作的返回类型
//    @ResponseBody
//    public  String  save(){
//        System.out.println("user save...");
//        return "{'OK!!!':'SpringMVC'}";
//    }
    @Autowired
    private UserService userService;

    @GetMapping
    public Result getAll() {
        List<User> userList = userService.getAll();
        Integer code = userList != null ? Code.GET_OK : Code.GET_OK;
        String msg = userList != null ? "" : "查询失败，请重新查询！";
        return new Result(code, userList, msg);

    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_OK;
        String msg = user != null ? "" : "查询失败，请重新查询！";
        return new Result(code, user, msg);

    }

    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);

    }

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }


}
