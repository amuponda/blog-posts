package com.example

import javax.inject.Singleton

@Singleton
class UserRepository {

    Map findByUserName(String username) {
        if (username == "test") {
            return [username: username, password: "encodedPassword"]
        }
    }
}
