package com.example.brainridgeassessment.service;

import com.example.brainridgeassessment.dto.TransactionHistoryDTO;
import com.example.brainridgeassessment.dto.TransferFundDTO;
import com.example.brainridgeassessment.model.Transaction;
import com.example.brainridgeassessment.model.User;
import com.example.brainridgeassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> transferFunds(TransferFundDTO transferFundDTO) {
        Optional<User> senderOption = userRepository.getFromId(transferFundDTO.getSenderId());
        Optional<User> receiverOption = userRepository.getFromId(transferFundDTO.getReceiverId());

        if (senderOption.isPresent() && receiverOption.isPresent()) {
            if (transferFundDTO.getAmount() > 0) {
                User sender = senderOption.get();
                User receiver = receiverOption.get();

                if (sender.getBalance() >= transferFundDTO.getAmount()) {
                    sender.setBalance(sender.getBalance() - transferFundDTO.getAmount());
                    receiver.setBalance(receiver.getBalance() + transferFundDTO.getAmount());

                    Transaction transaction = new Transaction(sender.getId(), receiver.getId(), transferFundDTO.getAmount());

                    sender.addTransaction(transaction);
                    receiver.addTransaction(transaction);

                    userRepository.save(sender);
                    userRepository.save(receiver);

                    return ResponseEntity.ok("Transaction was successful.");
                } else {
                    return ResponseEntity.ok("Insufficient funds for transaction.");
                }
            } else {
                return ResponseEntity.badRequest().body("Cannot transfer a negative amount.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid account IDs.");
        }
    }

    public ResponseEntity<?> getTransactionHistory(Long id) {
        Optional<User> userOption = userRepository.getFromId(id);
        if (userOption.isPresent()) {
            User user = userOption.get();
            TransactionHistoryDTO transactionHistoryDTO = new TransactionHistoryDTO(user.getTransactions());
            return ResponseEntity.ok(transactionHistoryDTO);
        } else {
            return ResponseEntity.badRequest().body("Invalid account ID.");
        }
    }
}
