package com.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private String firstName;
	private String lastName;
	private String role;
	private String email;
	private byte[] profile;
}
