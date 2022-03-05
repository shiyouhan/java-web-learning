package top.syhan.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: java-web-learning
 * @description: User实体类
 * @author: SYH
 * @create: 2022-02-28 15:46
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    /**
     * id 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
