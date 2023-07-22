package com.adgile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdgileController {

    @RequestMapping("/")
    public String init() {
        return "adgile backend API";
    }
}
