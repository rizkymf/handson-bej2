package org.binar.chapter6.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoRestTemplate {
    public void testRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://catfact.ninja/fact";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        System.out.println(response);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json = objectMapper.readTree(response.getBody());
            json.get("fact");
        } catch(Exception e) {

        }

    }
}
