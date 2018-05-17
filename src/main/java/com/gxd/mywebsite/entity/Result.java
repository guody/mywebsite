/**
 * FileName: Result
 * Author:   guody
 * Date:     2018/4/29 14:03
 * Description: 响应报文类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite.entity;

import java.io.Serializable;

/**
 * 〈响应报文类〉
 *
 * @author guody
 * @create 2018/4/29
 * @since 1.0.0
 */
public class Result implements Serializable {
    private String resCode;    // 状态码
    private String msg;    // 状态描述信息
    private boolean success;
    //返回数据
    private Object resData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResData() {
        return resData;
    }

    public void setResData(Object resData) {
        this.resData = resData;
    }
}