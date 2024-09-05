package com.example.brainridgeassessment.dto;

import com.example.brainridgeassessment.model.Transaction;

import java.util.List;

public class TransactionHistoryDTO {
    private List<Transaction> transactions;

    public TransactionHistoryDTO() {}

    public TransactionHistoryDTO(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
