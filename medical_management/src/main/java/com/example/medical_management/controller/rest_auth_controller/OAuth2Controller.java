//package com.example.medical_management.controller.rest_auth_controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nimbusds.openid.connect.sdk.claims.UserInfo;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.security.Principal;
//
//@Controller
//public class OAuth2Controller {
//
//    @RequestMapping("/successOauth")
//    public ResponseEntity<?> handleSuccessfulOAuth2Login(HttpServletResponse response, Principal principal) throws IOException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String principalJson = objectMapper.writeValueAsString(principal);
//        System.out.println(principalJson);
//        response.setContentType("text/html");
//        String script = "<script>window.opener.postMessage({ principal: " + principalJson + " }, '*'); window.close();</script>";
////        String script = "<script>window.opener.postMessage(successOauth, '*'); window.close();</script>";
//        response.getWriter().write(script);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/login/google")
//    public String googleLogin() {
//        // Redirect to Google login page
//        return "redirect:http://localhost:8080/oauth2/authorization/google";
//    }
//
//    @GetMapping("/login/google/callback")
//    public ResponseEntity<?> googleLoginCallback(@RequestParam("code") String code, @AuthenticationPrincipal OAuth2User principal) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String principalJson = objectMapper.writeValueAsString(principal);
//        return ResponseEntity.ok(principalJson);}
//    @GetMapping("/user")
//    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
//        // Retrieve user information from the 'principal' object
//        // You can access user data and return it as JSON
//
////        UserInfo userInfo = new UserInfo();
////        userInfo.setId(principal.getAttribute("sub"));
////        userInfo.setEmail(principal.getAttribute("email"));
////        userInfo.setName(principal.getAttribute("name"));
//
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
//}
