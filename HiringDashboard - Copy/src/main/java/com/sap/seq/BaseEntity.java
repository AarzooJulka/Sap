package com.sap.seq;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseEntity {
	@Id
	private long id;

	@JsonIgnore
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public abstract String getSequence();

}
