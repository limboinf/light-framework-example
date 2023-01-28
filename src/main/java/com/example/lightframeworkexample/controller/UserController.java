package com.example.lightframeworkexample.controller;

import com.example.lightframeworkexample.domain.resp.JacksonDateTimeResp;
import com.example.lightframeworkexample.service.UserService;
import com.limbo.light.core.domain.web.Result;
import com.limbo.light.web.api.ApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * description
 *
 * @author limbo
 * @since 2022/12/1 21:35
 */
@Slf4j
@RestController
@ResponseBody
public class UserController extends ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(@RequestParam(value = "userId") Long userId) {
        log.info("getUserController userId: {}", userId);
        return userService.getUserName(userId);
    }

    @GetMapping("/testDate")
    public Result<JacksonDateTimeResp> testDate() {
        JacksonDateTimeResp resp = new JacksonDateTimeResp();
        // 验证精度是否丢失
        resp.setId(1500829886697496578L);
        BigDecimal bigDecimal = BigDecimal.valueOf(987654321987654321.12345);
        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal.toPlainString());
        System.out.println(bigDecimal.stripTrailingZeros().toPlainString());
        System.out.println("--------");
        resp.setPrice(bigDecimal);
        resp.setAmount(BigInteger.valueOf(1500829886697496578L));
        // 验证日期时间格式化
        resp.setDate(new Date());
        resp.setLocalDateTime(LocalDateTime.now());
        log.info("mock resp: {}", resp);
        return success(resp);
    }
}
