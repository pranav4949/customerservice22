package com.customerservice.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@MongoId
	    private String customerId;
	    private String tradeAccountNo;
	    private String customerName;
	    private String dob;
	    private String pan;
	    private String phoneNumber;
	    private String emailID;
	    private Address address;

}
