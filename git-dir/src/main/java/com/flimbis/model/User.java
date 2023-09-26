package com.flimbis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    @JsonProperty("avatar_url")
    private String avatar;
    @JsonProperty(value = "url")
    private String path;
    private int following;
    private int followers;
    @JsonProperty("public_repos")
    private int repos;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
