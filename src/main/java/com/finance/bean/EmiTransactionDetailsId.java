package com.finance.bean;


import lombok.*;

import java.io.Serializable;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmiTransactionDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     quoteNo ;
    private String     productId ;   
    private Date       dueDate ;
    private String     instalment ;
}