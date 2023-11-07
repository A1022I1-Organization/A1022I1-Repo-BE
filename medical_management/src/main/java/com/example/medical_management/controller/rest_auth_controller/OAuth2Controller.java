package com.example.medical_management.controller.rest_auth_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Controller
public class OAuth2Controller {

    @RequestMapping("/successOauth")
    public ResponseEntity<?> handleSuccessfulOAuth2Login(HttpServletResponse response, Principal principal) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String principalJson = objectMapper.writeValueAsString(principal);
        System.out.println(principalJson);
        response.setContentType("text/html");
        String script = "<script>window.opener.postMessage({ principal: " + principalJson + " }, '*'); window.close();</script>";
//        String script = "<script>window.opener.postMessage(successOauth, '*'); window.close();</script>";
        response.getWriter().write(script);

        return ResponseEntity.ok().build();
    }
}
