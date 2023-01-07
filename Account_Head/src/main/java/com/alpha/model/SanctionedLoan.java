package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanctionedLoan {

	@Id
	private Integer id;
	private Integer tenure;
	private float rateofInt;
	private String name;
	private Double customerTotalLoanRequired;
	private String bankName;
	private Long accountNumber;
	private Double sanctionAmount;

}
