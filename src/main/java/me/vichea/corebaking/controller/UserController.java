package me.vichea.corebaking.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

        @GetMapping
        public String getUser() {
            return "Hello World";
        }

}
