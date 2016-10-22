package com.flashlogist.dom.user;

import lombok.Data;

public @Data
class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
