package com.example

import io.micronaut.security.authentication.providers.UserFetcher
import io.micronaut.security.authentication.providers.UserState
import io.reactivex.Flowable
import org.reactivestreams.Publisher

import javax.inject.Singleton

@Singleton
class UserFetcherService implements UserFetcher {

    private final UserRepository userRepository

    UserFetcherService(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @Override
    Publisher<UserState> findByUsername(String username) {
        Map userDetails = userRepository.findByUserName(username)
        (userDetails ? Flowable.just(new User(userDetails)) : Flowable.empty()) as Publisher<UserState>
    }
}
