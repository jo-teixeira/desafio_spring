package com.meli.desafiospring.exception.user;

import com.meli.desafiospring.exception.DefaultException;

public class UserNotFoundException extends DefaultException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
