package com.github.skanfa.core.libs.locallibs;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String firstname;

    @Getter
    @Setter
    private String lastname;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private int active;

    @Getter
    @Setter
    private Set<Role> roles;

}
