package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	private Integer custId;
	private String name;
	private Integer tenure;
	private float rateOfInt;
	private String agreementDate;
	private Double customerTotalLoanRequired;
	private String bankName;
	private Long accountNumber;
	private Double sanctionAmount;

}
