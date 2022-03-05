package top.syhan.web.exercise;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.syhan.web.exercise.entity.User;
import top.syhan.web.exercise.service.UserService;

/**
 * @program: java-web-learning
 * @description:
 * @author: SYH
 * @create: 2022-02-28 16:27
 **/
@Slf4j
class UserServiceTest {

    @Test
    void Login() {
        UserService userService = new UserService();
        User user = userService.login("zhangsan ", "123");
        if (user != null) {
            log.info(String.valueOf(user));
        }
    }
}
