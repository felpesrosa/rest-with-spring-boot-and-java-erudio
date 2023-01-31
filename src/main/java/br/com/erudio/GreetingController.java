package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greetings greeting(
        @RequestParam(value = "name", defaultValue = "World") String name,
        @RequestParam(value = "surname", defaultValue = "_unkown") String surname) {
            return new Greetings(counter.incrementAndGet(), String.format(template, name + surname));

    }
}
