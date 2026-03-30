package com.esther.fooddelivery.common;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/* return common result, all data encapsulation to be this object
* */
@Data
public class R<T> {
    // code msg data 都是前端需要接收的东西

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息，登录失败的时候

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    //响应成功的时候会自己new 一个R对象
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    //登录失败的时候返回的msg
    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
