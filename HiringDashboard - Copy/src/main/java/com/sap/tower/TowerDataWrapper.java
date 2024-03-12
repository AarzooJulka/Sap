package com.sap.tower;

import java.util.List;

public class TowerDataWrapper {
	private TowerData towerData;
	private List<Tower> towerDetails;

	public TowerDataWrapper() {
		super();
	}

	public TowerDataWrapper(TowerData towerData, List<Tower> towerDetails) {
		super();
		this.towerData = towerData;
		this.towerDetails = towerDetails;
	}

	public TowerData getTowerData() {
		return towerData;
	}

	public void setTowerData(TowerData towerData) {
		this.towerData = towerData;
	}

	public List<Tower> getTowerDetails() {
		return towerDetails;
	}

	public void setTowerDetails(List<Tower> towerDetails) {
		this.towerDetails = towerDetails;
	}

}
