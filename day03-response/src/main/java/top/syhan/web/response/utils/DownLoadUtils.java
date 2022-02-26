package top.syhan.web.response.utils;

import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @program: java-web-learning
 * @description: 下载工具
 * @author: SYH
 * @create: 2022-02-26 17:54
 **/
public class DownLoadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            Base64 base64Encoder = new Base64();
            filename = "=?utf-8?B?" + Arrays.toString(base64Encoder.encode(filename.getBytes(StandardCharsets.UTF_8))) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
        }
        return filename;
    }
}
