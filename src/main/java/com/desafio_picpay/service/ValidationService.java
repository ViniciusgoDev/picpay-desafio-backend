package com.desafio_picpay.service;

import com.desafio_picpay.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ValidationService {

    private final RestTemplate restTemplate;

    public ValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean authorizeTransaction(Users payer, BigDecimal amount) {

//        String url = "https://util.devi.tools/api/v1/notify";
//
//        ResponseEntity<Map> authorization = restTemplate.getForEntity(url, Map.class);
//
//        if (authorization.getStatusCode() == HttpStatus.OK && "true".equals(authorization.getBody().get("authorization"))) {
//            return true;
//        }
        return true;
    }
}
