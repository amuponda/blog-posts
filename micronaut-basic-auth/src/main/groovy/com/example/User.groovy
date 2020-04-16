package com.example

import groovy.transform.ToString
import io.micronaut.security.authentication.providers.UserState

@ToString(includeNames=true)
class User implements UserState {

    String username
    String password

    User(Map params) {
        this.username = params.username
        this.password = params.password
    }

    @Override
    String getUsername() {
        return username
    }

    @Override
    String getPassword() {
        return password
    }

    @Override
    boolean isEnabled() {
        return true
    }

    @Override
    boolean isAccountExpired() {
        return false
    }

    @Override
    boolean isAccountLocked() {
        return false
    }

    @Override
    boolean isPasswordExpired() {
        return false
    }
}
