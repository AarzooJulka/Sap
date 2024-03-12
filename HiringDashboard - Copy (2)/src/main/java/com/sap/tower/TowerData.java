package com.sap.tower;

import java.util.List;

public class TowerData {

	private String totalOnboarded;
	private String actualOnboarded;
	private String totalOfferReleased;
	private String actualOfferReleased;
	private String totalOfferAccepted;
	private String actualOfferAccepted;
	private List<String> topManagers;

	public TowerData() {
		super();
	}

	public TowerData(String totalOnboarded, String actualOnboarded, String totalOfferReleased,
			String actualOfferReleased, String totalOfferAccepted, String actualOfferAccepted,
			List<String> topManagers) {
		super();
		this.totalOnboarded = totalOnboarded;
		this.actualOnboarded = actualOnboarded;
		this.totalOfferReleased = totalOfferReleased;
		this.actualOfferReleased = actualOfferReleased;
		this.totalOfferAccepted = totalOfferAccepted;
		this.actualOfferAccepted = actualOfferAccepted;
		this.topManagers = topManagers;
	}

	public String getTotalOnboarded() {
		return totalOnboarded;
	}

	public void setTotalOnboarded(String totalOnboarded) {
		this.totalOnboarded = totalOnboarded;
	}

	public String getActualOnboarded() {
		return actualOnboarded;
	}

	public void setActualOnboarded(String actualOnboarded) {
		this.actualOnboarded = actualOnboarded;
	}

	public String getTotalOfferReleased() {
		return totalOfferReleased;
	}

	public void setTotalOfferReleased(String totalOfferReleased) {
		this.totalOfferReleased = totalOfferReleased;
	}

	public String getActualOfferReleased() {
		return actualOfferReleased;
	}

	public void setActualOfferReleased(String actualOfferReleased) {
		this.actualOfferReleased = actualOfferReleased;
	}

	public String getTotalOfferAccepted() {
		return totalOfferAccepted;
	}

	public void setTotalOfferAccepted(String totalOfferAccepted) {
		this.totalOfferAccepted = totalOfferAccepted;
	}

	public String getActualOfferAccepted() {
		return actualOfferAccepted;
	}

	public void setActualOfferAccepted(String actualOfferAccepted) {
		this.actualOfferAccepted = actualOfferAccepted;
	}

	public List<String> getTopManagers() {
		return topManagers;
	}

	public void setTopManagers(List<String> topManagers) {
		this.topManagers = topManagers;
	}

}
