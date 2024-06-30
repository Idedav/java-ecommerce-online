package com.ecommerceOn.ecommerceOn.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "surname")
	private String surname;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "password")
	private String password;


}
