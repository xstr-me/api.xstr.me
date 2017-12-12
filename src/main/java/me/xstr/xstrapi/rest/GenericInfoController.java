package me.xstr.xstrapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.xstrapi.model.GenericInfo;

@RestController
public class GenericInfoController {

	@Autowired
	private GenericInfo genericInfo;
	
    @RequestMapping("/")
    public GenericInfo genericInfo() {
    	return genericInfo;
    }

}
