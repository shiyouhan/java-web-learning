package top.syhan.web.ajax.entity;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-web-learning
 * @description: Fastjson练习
 * @author: SYH
 * @create: 2022-03-02 20:52
 **/

@Slf4j
public class FastjsonDemo {
    public static void main(String[] args) {
        //1. 将Java对象转为JSON字符串
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        //{"id":1,"password":"123","username":"zhangsan"}
        log.info(jsonString);

        //2. 将JSON字符串转为Java对象
        User u = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        log.info(String.valueOf(u));
    }
}
