package com.example.springdockerdeploy;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final Environment env;

    @GetMapping("/")
    public String gyunny() {
        List<String> profile = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real1", "real2");
        String defaultProfile = profile.isEmpty() ? "default" : profile.get(0);

        return profile.stream()
            .filter(realProfiles::contains)
            .findAny()
            .orElse(defaultProfile);
    }

    @GetMapping("/hello")
    public String hello() {
        return "무중단 배포 2222222222222 !!";
    }
}
