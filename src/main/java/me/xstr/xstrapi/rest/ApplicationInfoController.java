package me.xstr.xstrapi.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.xstr.xstrapi.model.ApplicationInfo;

@RestController
public class ApplicationInfoController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/info")
    public ApplicationInfo applicationInfo(@RequestParam(value="name", defaultValue="World") String name) {
        return new ApplicationInfo(counter.incrementAndGet(),
                            String.format(template, name));
    }

}
