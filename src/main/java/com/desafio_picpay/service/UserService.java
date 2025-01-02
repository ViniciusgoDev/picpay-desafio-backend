package com.desafio_picpay.service;

import com.desafio_picpay.Dtos.TransferRequest;
import com.desafio_picpay.Repository.UserRepository;
import com.desafio_picpay.entity.Users;
import com.desafio_picpay.entity.enums.UserType;
import com.desafio_picpay.exceptions.NotPermittedException;
import com.desafio_picpay.exceptions.InsufficientFundsException;
import com.desafio_picpay.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  ValidationService validationService;
    @Autowired
    private  NotificationService notificationService;

    @Transactional
    public ResponseEntity<?>  transfer(TransferRequest transferRequest) {

        validateTransferData(transferRequest);

        Users payer = userRepository.findById(transferRequest.getPayer())
                .orElseThrow(() -> new UserNotFoundException("Pagador não encontrado"));
        Users payee = userRepository.findById(transferRequest.getPayee())
                .orElseThrow(() -> new UserNotFoundException("Beneficiário não encontrado"));

        validateTransfer(payer, payer.getWalletBalance());


        executeTransfer(payer, payee, transferRequest.getValue());

        notificationService.NotificationTransferReceived(payee);

        return ResponseEntity.status(HttpStatus.OK).build();


    }

    private void validateTransferData(TransferRequest transferRequest) {
        if (transferRequest.getPayer() == null || transferRequest.getPayee() == null) {
            throw new IllegalArgumentException("IDs dos usuários não podem ser nulos");
        }
        if (transferRequest.getPayer().equals(transferRequest.getPayee())) {
            throw new IllegalArgumentException("Pagador e beneficiário não podem ser o mesmo usuário");
        }
        if (transferRequest.getValue() == null || transferRequest.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser maior que zero");
        }
    }

    private void validateTransfer(Users payer, BigDecimal amount) {
        if (payer.getUserType() == UserType.STORE) {
            throw new NotPermittedException();
        }
        if (amount.compareTo(payer.getWalletBalance()) > 0) {
            throw new InsufficientFundsException("Saldo insuficiente para realizar a transferência");
        }

        validationService.authorizeTransaction(payer, amount);
    }

    private void executeTransfer(Users payer, Users payee, BigDecimal amount) {
        payer.setWalletBalance(payer.getWalletBalance().subtract(amount));
        payee.setWalletBalance(payee.getWalletBalance().add(amount));

        userRepository.save(payer);
        userRepository.save(payee);
    }

}
