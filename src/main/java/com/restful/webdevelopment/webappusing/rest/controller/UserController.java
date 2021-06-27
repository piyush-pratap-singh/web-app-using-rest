package com.restful.webdevelopment.webappusing.rest.controller;

import com.restful.webdevelopment.webappusing.rest.model.request.UserRequest;
import com.restful.webdevelopment.webappusing.rest.model.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path="/{userId}",
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId){

        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName("Piyush");
        userResponse.setLastName("Pratap Singh");
        userResponse.setEmail("piyushpratap1707@gmail.com");

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue = "2") int page,
                          @RequestParam(value="limit", defaultValue = "3") int limit){
        return "get user was called userId page and limit" + " "+page + " "
                +limit;
    }

    @PostMapping( produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(userRequest.getFirstName());
        userResponse.setLastName(userRequest.getLastName());
        userResponse.setEmail(userRequest.getEmail());

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
