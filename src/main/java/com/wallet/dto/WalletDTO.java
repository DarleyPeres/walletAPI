package com.wallet.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletDTO {

	private Long id;
	@Length(min = 3, message="Name must be at least 3 characteres")
	@NotNull(message = "Name must not be NULL")
	private String name;
	@NotNull(message = "Value must not be NULL")
	private BigDecimal value;
}
