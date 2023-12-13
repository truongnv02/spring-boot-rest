package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.entity.Root;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/SSO")
public class GoogleController {

    @GetMapping("/signin-google")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken authenticationToken) {
        return authenticationToken.getPrincipal().getAttributes();
    }

    public Root toPerson(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return Root.builder()
                .email((String) map.get("email"))
                .name((String) map.get("name"))
                .picture((String) map.get("picture"))
                .build();
    }
}
