package com.mbinfotechworld.xml_example.controller;

import com.mbinfotechworld.xml_example.model.UserRequest;
import com.mbinfotechworld.xml_example.model.UserResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String showMessage() {
        return "this is the spring boot application";
    }

    // accept JSON and return XML
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public UserResponse getUserInfo(@RequestBody UserRequest userRequest) {
        //create response based on the request data
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userRequest.getUserId());
        userResponse.setStatus("success");
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setAge(userRequest.getAge());
        userResponse.setName(userRequest.getName());
        return userResponse;
    }
}
