package com.wallet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



@Entity
@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2244020670569423514L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String email;
}
