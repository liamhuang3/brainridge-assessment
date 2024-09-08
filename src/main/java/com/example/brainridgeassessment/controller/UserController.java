package com.example.brainridgeassessment.controller;

import com.example.brainridgeassessment.dto.TransactionHistoryDTO;
import com.example.brainridgeassessment.dto.TransferFundDTO;
import com.example.brainridgeassessment.dto.UserCreateDTO;
import com.example.brainridgeassessment.service.TransactionService;
import com.example.brainridgeassessment.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody(required = false) UserCreateDTO userCreateDTO) {
        // if a request body is not provided then we just create a new account with a balance of zero
        if (userCreateDTO == null) {
            userCreateDTO = new UserCreateDTO(0);
        }
        return userService.createUser(userCreateDTO);
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> createTransaction(@RequestBody TransferFundDTO transferFundDTO) {
        return transactionService.transferFunds(transferFundDTO);
    }

    @GetMapping(value="/{id}/transactions", produces = "application/json")
    public ResponseEntity<TransactionHistoryDTO> getTransactionHistory(@PathVariable Long id) {
        return transactionService.getTransactionHistory(id);
    }
}
