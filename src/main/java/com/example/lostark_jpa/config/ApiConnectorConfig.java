package com.example.lostark_jpa.config;

import com.example.lostark_jpa.api.LostArkApiRepositoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApiConnectorConfig {

    @Bean
    LostArkApiRepositoryService lostArkApiConnector() {
        WebClient client = WebClient
                .builder()
                .baseUrl("https://developer-lostark.game.onstove.com")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAyOTg0MjUifQ.I7sA9qLun29-MRgJhIAzH2tEp7Bq71gZbWd5ODyXqCpKDh8LfVROcw6n476MYI7goIGQ7L25PmD8TQxXkviK2csv4B7v7q9-vmVNTZyxEMKsWYNusZQ3s46WhSie_9yT-SaYw744G1yrcjEv0e6EtcDxlkIvYL5Fzr_3z65_tp3D471UIF_y4ugPK9ealPW8dsyiPGpOAgK0SyZ_rS47OpoKX_Yq6cSHsKwX_7kXhgQbJwZNGzArfjLNvs0eAO65lHO3UGQ4OOzQhBiG9ZeP-CrID0cm4J_m3wvMeckxyVJRxlZmGwkiCivljD4idswgts9ispuf8qkWzv__7iqkMg")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();

        return httpServiceProxyFactory.createClient(LostArkApiRepositoryService.class);
    }
}
