package com.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiDetails {
	
	@Id
	@SequenceGenerator(name = "abc", sequenceName = "emi_sequence", initialValue = 3521500,allocationSize = 1)
	@GeneratedValue(generator = "abc", strategy = GenerationType.AUTO)
	private Integer emiId;
	private String emiStatus;
	private Long emiAmount;
	private Integer emiTenure;	
	private String emiPaid;
	private Integer defaultorCount;
	
	


}
