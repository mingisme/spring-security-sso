package com.swang.resource.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @RequestMapping("/userInfo")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
