package com.mercadolivre.desafioSpring.controllers;

import com.mercadolivre.desafioSpring.requests.PostToCreateRequest;
import com.mercadolivre.desafioSpring.responses.PostInfoResponse;
import com.mercadolivre.desafioSpring.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class PostController {

    private final PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<PostInfoResponse> createUser(@RequestBody @Valid PostToCreateRequest postToCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postToCreateRequest));
    }

}