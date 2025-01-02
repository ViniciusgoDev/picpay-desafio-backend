package com.desafio_picpay.Dtos;
import java.math.BigDecimal;


public class TransferRequest {
        private Long payer;
        private Long payee;
        private BigDecimal value;

    public Long getPayer() {
        return payer;
    }

    public void setPayer(Long payer) {
        this.payer = payer;
    }

    public Long getPayee() {
        return payee;
    }

    public void setPayee(Long payee) {
        this.payee = payee;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
