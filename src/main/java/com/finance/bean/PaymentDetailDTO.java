package com.finance.bean;

import lombok.Data;

@Data
public class PaymentDetailDTO {
	private String paymentMode;
    private String payeeName;

    public PaymentDetailDTO(String paymentMode, String payeeName) {
        this.paymentMode = paymentMode;
        this.payeeName = payeeName;
    }
}