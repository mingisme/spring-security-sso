package com.swang.authz.server;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/userInfo")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
