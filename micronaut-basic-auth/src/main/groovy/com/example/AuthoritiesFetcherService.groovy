package com.example

import io.micronaut.security.authentication.providers.AuthoritiesFetcher
import io.reactivex.Flowable
import org.reactivestreams.Publisher

import javax.inject.Singleton

@Singleton
class AuthoritiesFetcherService implements AuthoritiesFetcher {

    @Override
    Publisher<List<String>> findAuthoritiesByUsername(String username) {
        return Flowable.empty() as Publisher<List<String>> // not going to be using an authorities for this tutorial
    }
}
