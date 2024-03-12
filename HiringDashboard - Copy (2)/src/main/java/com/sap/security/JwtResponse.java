package com.sap.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = 4772951141376237705L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
