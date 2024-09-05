package com.example.brainridgeassessment.dto;

public class TransferFundDTO {
    private Long senderId;
    private Long receiverId;
    private double amount;

    public Long getSenderId() {
        return senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public double getAmount() {
        return amount;
    }
}
