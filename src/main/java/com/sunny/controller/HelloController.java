package com.sunny.controller;

import com.sunny.properties.GirlProPerties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProPerties girlProPerties;

//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value="/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {

        return "id: " + id;
    }
}
