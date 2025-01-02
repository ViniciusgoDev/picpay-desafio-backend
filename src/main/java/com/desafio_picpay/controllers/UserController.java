package com.desafio_picpay.controllers;

import com.desafio_picpay.Dtos.TransferRequest;
import com.desafio_picpay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/transfer")
    public ResponseEntity<?>  transfer (@RequestBody TransferRequest transferRequest){
         return userService.transfer(transferRequest);
    }




}
