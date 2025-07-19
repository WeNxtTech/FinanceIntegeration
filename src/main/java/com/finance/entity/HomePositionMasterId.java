package com.finance.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/**
 * Composite primary key for entity "HomePositionMaster" ( stored in table "home_position_master" )
 *
 * @author Telosys
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class HomePositionMasterId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     requestReferenceNo ;
    
    private String    quoteNo ;
    
    private Integer    noOfVehicles ;
    
    private Integer    agencyCode ;
    
     
}
