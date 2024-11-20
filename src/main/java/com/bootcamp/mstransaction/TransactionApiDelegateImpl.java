package com.bootcamp.mstransaction;

import com.bootcamp.mstransaction.api.TransactionApiDelegate;
import com.bootcamp.mstransaction.model.DepositRequest;
import com.bootcamp.mstransaction.model.WithdrawalRequest;
import com.bootcamp.mstransaction.model.TransferRequest;
import com.bootcamp.mstransaction.model.Error;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class TransactionApiDelegateImpl implements TransactionApiDelegate {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public ResponseEntity<DepositRequest> registerDeposit(DepositRequest depositRequest) {
        depositRequest.setDate(OffsetDateTime.parse(LocalDateTime.now().format(formatter)));
        return ResponseEntity.status(201).body(depositRequest);
    }

    @Override
    public ResponseEntity<WithdrawalRequest> registerWithdrawal(WithdrawalRequest withdrawalRequest) {
        withdrawalRequest.setDate(OffsetDateTime.parse(LocalDateTime.now().format(formatter)));
        return ResponseEntity.status(201).body(withdrawalRequest);
    }

    @Override
    public ResponseEntity<TransferRequest> registerTransfer(TransferRequest transferRequest) {
        transferRequest.setDate(OffsetDateTime.parse(LocalDateTime.now().format(formatter)));
        return ResponseEntity.status(201).body(transferRequest);
    }
}
