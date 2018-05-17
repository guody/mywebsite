/**
 * FileName: UserService
 * Author:   guody
 * Date:     2018/4/21 17:01
 * Description: user接口类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.service;

import com.gxd.mywebsite.entity.Result;
import com.gxd.mywebsite.entity.user.User;

/**
 * 〈user接口类〉
 *
 * @author guody
 * @create 2018/4/21
 * @since 1.0.0
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
   Result registUser(User user);

    /**
     * 登陆判断用户名和密码
     * @param username
     * @param password
     * @return
     */
    Result checkLogin(String username,String password);

    /**
     * 检索出用户名和密码
     * @param auth
     * @return
     */
    Result checkLogin(String auth) throws Exception;

}
