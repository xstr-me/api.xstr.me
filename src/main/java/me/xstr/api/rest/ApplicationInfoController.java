package me.xstr.api.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.api.domain.ApplicationInfo;

@RestController
public class ApplicationInfoController {
	private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/info")
    public ApplicationInfo applicationInfo(@RequestParam(value="name", defaultValue="World") String name) {
        return new ApplicationInfo(counter.incrementAndGet(),
                            String.format(TEMPLATE, name));
    }

}
