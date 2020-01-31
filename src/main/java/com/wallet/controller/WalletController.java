package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.WalletDTO;
import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.WalletService;

@RestController
@RequestMapping("wallet")
public class WalletController {

	@Autowired
	private WalletService service;
	
	@PostMapping
	public ResponseEntity<Response<WalletDTO>> create(@Valid @RequestBody WalletDTO walletDTO, BindingResult result ) {
		Response<WalletDTO> response = new Response<WalletDTO>();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.addError(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		Wallet wallet = service.save(convert(walletDTO));
		response.setData(convert(wallet));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Wallet convert(WalletDTO dto) {
		Wallet wallet = new Wallet();
		wallet.setId(dto.getId());
		wallet.setName(dto.getName());
		wallet.setValue(dto.getValue());
		return wallet;
	}
	
	private WalletDTO convert(Wallet wallet) {
		WalletDTO dto = new WalletDTO();
		dto.setId(wallet.getId());
		dto.setName(wallet.getName());
		dto.setValue(wallet.getValue());
		return dto;
	}
}
