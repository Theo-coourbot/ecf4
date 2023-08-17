package com.observation.observation.tool;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClient<T,V> {

    private String urlApiCelestialObj = "http://localhost:8082/celestialObj";

    private String urlApiToken = "http://localhost:8083/api/token";
    private String urlApiUser = "http://localhost:8083/auth";

    private RestTemplate template;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient() {
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T getUser(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiUser+uri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }

    public T getCelestialObj(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiCelestialObj+uri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }
    public boolean testToken(String token, Class<T> type) {
        httpHeaders.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiToken, HttpMethod.GET, requestEntity, type);
        if(response.hasBody()) {
            return response.getStatusCode().is2xxSuccessful();
        }
        return false;
    }

}
