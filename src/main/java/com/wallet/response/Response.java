package com.wallet.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Response<T> {

	private T data;
	private List<String> errors;
	
	public boolean addError(String error) {
		if (errors == null) {
			errors = new ArrayList<String>();
		}
		return errors.add(error);
	}
	
}
