package com.spring.api.version.controller;

import com.spring.api.version.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public void list() {
        System.out.println("------default version------");
    }

    @GetMapping("/list")
    @ApiVersion("1.0.0")
    @Deprecated
    public void list1_0_0() {
        System.out.println("-------1.0.0 version-------");
    }

    @GetMapping("/list")
    @ApiVersion("1.0.2")
    public void list1_0_2() {
        System.out.println("-------1.0.2 version-------");
    }

    @GetMapping("/list")
    @ApiVersion("1.3.0")
    public void list1_3_0() {
        System.out.println("-------1.3.0 version-------");
    }

}
