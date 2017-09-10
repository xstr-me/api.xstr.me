package me.xstr.xstrapi.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.xstrapi.model.GenericInfo;

@RestController
public class GenericInfoController {

    @RequestMapping("/")
    public GenericInfo genericInfo() {
        return new GenericInfo();
    }

}
