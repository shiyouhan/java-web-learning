package top.syhan.web.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: java-web-learning
 * @description:
 * @author: SYH
 * @create: 2022-03-02 21:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String account;
    private String password;
}
