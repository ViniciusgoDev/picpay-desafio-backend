package com.desafio_picpay.service;

import com.desafio_picpay.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean NotificationTransferReceived(Users user){
//        String url = "https://util.devi.tools/api/v1/notify";
//
//        ResponseEntity<Map> notification = restTemplate.getForEntity(url, Map.class);

        return true;

    }

}
