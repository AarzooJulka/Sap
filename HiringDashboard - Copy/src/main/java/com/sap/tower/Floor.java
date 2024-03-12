package com.sap.tower;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sap.seq.BaseEntity;

@Document(collection = "floor")
public class Floor extends BaseEntity {

	// private long towerId;
	private String floorNo;
	private String outlinedWindow;
	private String emptyWindow;
	private String brokenWindow;
	private String illuminatedWindow;
	private String occupiedWindow;

	public Floor() {
		super();
	}

	public Floor(/* long towerId, */ String outlinedWindow, String emptyWindow, String brokenWindow,
			String illuminatedWindow, String occupiedWindow, String floorNo) {
		super();
		// this.towerId = towerId;
		this.outlinedWindow = outlinedWindow;
		this.emptyWindow = emptyWindow;
		this.brokenWindow = brokenWindow;
		this.illuminatedWindow = illuminatedWindow;
		this.occupiedWindow = occupiedWindow;
		this.floorNo = floorNo;
	}

	/*
	 * public long getTowerId() { return towerId; }
	 * 
	 * public void setTowerId(long towerId) { this.towerId = towerId; }
	 */

	public String getOutlinedWindow() {
		return outlinedWindow;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public void setOutlinedWindow(String outlinedWindow) {
		this.outlinedWindow = outlinedWindow;
	}

	public String getEmptyWindow() {
		return emptyWindow;
	}

	public void setEmptyWindow(String emptyWindow) {
		this.emptyWindow = emptyWindow;
	}

	public String getBrokenWindow() {
		return brokenWindow;
	}

	public void setBrokenWindow(String brokenWindow) {
		this.brokenWindow = brokenWindow;
	}

	public String getIlluminatedWindow() {
		return illuminatedWindow;
	}

	public void setIlluminatedWindow(String illuminatedWindow) {
		this.illuminatedWindow = illuminatedWindow;
	}

	public String getOccupiedWindow() {
		return occupiedWindow;
	}

	public void setOccupiedWindow(String occupiedWindow) {
		this.occupiedWindow = occupiedWindow;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		// TODO Auto-generated method stub
		return "FLOOR_SEQ";
	}

}
