package com.flimbis.service;

import com.flimbis.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class LookupService {
    private final RestClient restClient;

    public LookupService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Async
    public CompletableFuture<User> findByLogin(String user) {
        User gitUser = restClient.get()
                .uri("/users/{user}", user)
                .accept(APPLICATION_JSON)
                .retrieve()
                .body(User.class);

        return CompletableFuture.completedFuture(gitUser);
    }
}
