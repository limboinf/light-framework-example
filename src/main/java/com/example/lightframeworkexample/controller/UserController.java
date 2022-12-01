package com.example.lightframeworkexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author limbo
 * @since 2022/12/1 21:35
 */
@Slf4j
@RestController
@ResponseBody
public class UserController {

    @GetMapping("/user")
    public String getUser(@RequestParam(value = "userId") Integer userId) {
        log.info("userId: {}", userId);
        return "Jack";
    }
}
