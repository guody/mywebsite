/**
 * FileName: User
 * Author:   guody
 * Date:     2018/4/28 15:20
 * Description: 用户信息实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.entity.user;

import java.io.Serializable;

/**
 * 〈用户信息实体类〉
 *
 * @author guody
 * @create 2018/4/28
 * @since 1.0.0
 */
public class User implements Serializable {
    private String userId;    // 用户id
    private String userName;  // 用户名
    private String nickName;  // 昵称
    private String password;  // 密码
    private String userToken;  // 身份令牌

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", userToken='" + userToken + '\'' +
                '}';
    }
}