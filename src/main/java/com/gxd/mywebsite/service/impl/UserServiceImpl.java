/**
 * FileName: UserServiceImpl
 * Author:   guody
 * Date:     2018/4/21 17:02
 * Description: user实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.service.impl;

import com.gxd.mywebsite.dao.UserDao;
import com.gxd.mywebsite.entity.Result;
import com.gxd.mywebsite.entity.user.User;
import com.gxd.mywebsite.service.UserService;
import com.gxd.mywebsite.util.Utils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈user实现类〉
 *
 * @author guody
 * @create 2018/4/21
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Result registUser(User user) {
        Result result = new Result();
        // 用户名检查
        if("".equals(user.getUserName()) || user.getUserName()==null){
            result.setResCode("01");
            result.setSuccess(false);
            result.setMsg("用户名不能为空");
            return result;
        }
        //用户名唯一性检查
        User us = userDao.findUserByName(user.getUserName());
        if(us != null){
            result.setResCode("02");
            result.setSuccess(false);
            result.setMsg("用户名已占用，请重新输入");
            return result;
        }
        // 密码检查
        if("".equals(user.getPassword()) || user.getPassword()==null){
            result.setResCode("03");
            result.setSuccess(false);
            result.setMsg("密码设置不能为空");
            return result;
        }
        //生成Id
        String userId = Utils.createId();
        user.setUserId(userId);
        //密码md5加密
        String md5_pwd = Utils.md5(user.getPassword());
        user.setPassword(md5_pwd);
        //执行插入
        userDao.saveUser(user);
        result.setResCode("00");
        result.setSuccess(true);
        result.setMsg("注册成功");
        result.setResData("");
        return result;
    }

    @Override
    public Result checkLogin(String username, String password) {
        Result result = new Result();
        //判断用户名
        User user = userDao.findUserByName(username);
        System.out.println("----------------------"+user);
        if(user==null){
            result.setResCode("01");
            result.setSuccess(false);
            result.setMsg("用户名不存在");
            result.setResData("");
            return result;
        }
        //判断密码
        String md5_pwd = Utils.md5(password);
        if(!user.getPassword().equals(md5_pwd)){
            result.setResCode("02");
            result.setSuccess(false);
            result.setMsg("密码错误");
            result.setResData("");
            return result;
        }

        // 成功，生成一个token
        String token = Utils.createToken();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userToken",token);
        params.put("userId",user.getUserId());
        userDao.updateToken(params);
        result.setResCode("00");//00正确
        result.setSuccess(true);
        result.setMsg("登录成功");
        result.setResData(params); //传递到客户端
        return result;
    }

    @Override
    public Result checkLogin(String auth) throws Exception{
        //HTTP Basic Authentication
        String base64_msg = auth.substring(auth.indexOf(" "));
        System.out.println("base64_msg:"+base64_msg);
        byte[] output = Base64.decodeBase64(base64_msg.getBytes());
        String msg = new String(output,"UTF-8");
        System.out.println("msg:"+msg);
        String[] msg_arr = msg.split(":");
        String user_name = msg_arr[0];
        String password = msg_arr[1];
        System.out.println("username:"+user_name);
        System.out.println("password:"+password);
        return checkLogin(user_name,password);
    }
}