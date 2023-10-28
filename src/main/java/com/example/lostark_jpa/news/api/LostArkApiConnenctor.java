package com.example.lostark_jpa.news.api;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class LostArkApiConnenctor {

    public Object call(ApiSpec apiSpec , Map<String, Object> requestBody) throws Exception {

        String baseUrl = "https://developer-lostark.game.onstove.com";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set(HttpHeaders.AUTHORIZATION, "bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDAyOTg0MjUifQ.I7sA9qLun29-MRgJhIAzH2tEp7Bq71gZbWd5ODyXqCpKDh8LfVROcw6n476MYI7goIGQ7L25PmD8TQxXkviK2csv4B7v7q9-vmVNTZyxEMKsWYNusZQ3s46WhSie_9yT-SaYw744G1yrcjEv0e6EtcDxlkIvYL5Fzr_3z65_tp3D471UIF_y4ugPK9ealPW8dsyiPGpOAgK0SyZ_rS47OpoKX_Yq6cSHsKwX_7kXhgQbJwZNGzArfjLNvs0eAO65lHO3UGQ4OOzQhBiG9ZeP-CrID0cm4J_m3wvMeckxyVJRxlZmGwkiCivljD4idswgts9ispuf8qkWzv__7iqkMg");
        HttpEntity entity = new HttpEntity("parameters", headers);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .fromUriString(apiSpec.getEndPoint()).build();

        ResponseEntity response = null;



        if (apiSpec.getHttpMethod().equals(HttpMethod.GET)) {
            response = new RestTemplate().getForEntity(baseUrl+ apiSpec.getEndPoint(), String.class, headers);
        } else if (apiSpec.getHttpMethod().equals(HttpMethod.POST)) {
            response = new RestTemplate().postForEntity(baseUrl+ apiSpec.getEndPoint(), requestBody, String.class, entity);
        } else {
            new RuntimeException();
        }


        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException();
        }
    }

}
