package com.meli.desafiospring.gateway.controller;

import com.meli.desafiospring.gateway.request.PostRequest;
import com.meli.desafiospring.gateway.response.UserResponse;
import com.meli.desafiospring.service.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/product/")
public class PostController {

    private final PostService postService;

    @PostMapping(value = "/newpost")
    public ResponseEntity<HttpStatus> createPost(@Valid @RequestBody PostRequest postRequest){
        postService.createPost(postRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/followed/{userId}/list")
    public ResponseEntity<UserResponse> getPostsOfSellersFollowed(@PathVariable Integer userId){
        UserResponse userResponse = postService.getPostsOfSellersFollowed(userId);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
