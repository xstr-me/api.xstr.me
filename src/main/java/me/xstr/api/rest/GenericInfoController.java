package me.xstr.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.api.models.GenericInfo;

@RestController
public class GenericInfoController {

	@Autowired
	private GenericInfo genericInfo;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/")
	public GenericInfo genericInfo() {
		return genericInfo;
	}

}
