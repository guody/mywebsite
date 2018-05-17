/**
 * FileName: UserDao
 * Author:   guody
 * Date:     2018/4/21 16:47
 * Description: user
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.dao;

import com.gxd.mywebsite.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 〈user〉
 *
 * @author guody
 * @create 2018/4/21
 * @since 1.0.0
 */
@Component
@Mapper
public interface UserDao {
    public int saveUser(User user);
    public User findUserByName(String name);
    public int updateToken(Map<String,Object> params);

}
