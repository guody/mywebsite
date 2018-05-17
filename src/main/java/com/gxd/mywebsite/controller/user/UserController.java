/**
 * FileName: UserController
 * Author:   guody
 * Date:     2018/5/7 19:03
 * Description: 操作用户类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.controller.user;

import com.gxd.mywebsite.entity.Result;
import com.gxd.mywebsite.entity.user.User;
import com.gxd.mywebsite.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈操作用户类〉
 *
 * @author guody
 * @create 2018/5/7
 * @since 1.0.0
 */
@RestController
@Api(value = "UserController", description = "用户相关api")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value="/regist", method=RequestMethod.POST)
    @ApiOperation(value="用户注册",httpMethod = "POST", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "No Name Provided"),
    })
    public Result addUser(User user){
        System.out.println(user);
        Result result = userService.registUser(user);
        return result;
    }


    @PostMapping("/login")
    @ApiOperation(value="用户登录",httpMethod = "POST", notes="用户名和密码判断")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "String")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "No Name Provided"),
    })
    public Result login(String userName, String password)throws Exception{
//        String auth = request.getHeader("Authorization");
        System.out.println("userName------"+userName);
        Result result = userService.checkLogin(userName,password);
        return result;
    }

}