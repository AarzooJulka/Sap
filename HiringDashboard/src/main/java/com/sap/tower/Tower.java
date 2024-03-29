package com.sap.tower;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sap.seq.BaseEntity;

@Document(collection = "tower")
public class Tower extends BaseEntity {
	private String towerNumber;
	private String towerName;
	private String skillsCount;
	private String towerColor;
	private String spiralTarget;
	private String topManager1;
	private String topManager2;
	private String greenManager;
	private String redManager;
	private String floorCount;
	private String outlinedWindow;
	private String emptyWindow;
	private String brokenWindow;
	private String illuminatedWindow;
	private String occupiedWindow;
	private String windowCount;
	private String target;
	private List<Floor> floorDetails;
	private List<Skill> skillDetails;

	public Tower() {
		super();
	}

	public Tower(String towerName, String skillsCount, String towerColor, String spiralTarget, String topManager1,
			String topManager2, String greenManager, String redManager, String floorCount, String outlinedWindow,
			String emptyWindow, String brokenWindow, String illuminatedWindow, String occupiedWindow,
			List<Floor> floorDetails, List<Skill> skillDetails, String windowCount, String towerNumber, String target) {
		super();
		this.towerName = towerName;
		this.skillsCount = skillsCount;
		this.towerColor = towerColor;
		this.spiralTarget = spiralTarget;
		this.topManager1 = topManager1;
		this.topManager2 = topManager2;
		this.greenManager = greenManager;
		this.redManager = redManager;
		this.floorCount = floorCount;
		this.outlinedWindow = outlinedWindow;
		this.emptyWindow = emptyWindow;
		this.brokenWindow = brokenWindow;
		this.illuminatedWindow = illuminatedWindow;
		this.occupiedWindow = occupiedWindow;
		this.floorDetails = floorDetails;
		this.skillDetails = skillDetails;
		this.windowCount = windowCount;
		this.towerNumber = towerName;
		this.target = target;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		// TODO Auto-generated method stub
		return "TOWER_SEQ";
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTowerNumber() {
		return towerNumber;
	}

	public void setTowerNumber(String towerNumber) {
		this.towerNumber = towerNumber;
	}

	public String getWindowCount() {
		return windowCount;
	}

	public void setWindowCount(String windowCount) {
		this.windowCount = windowCount;
	}

	public String getTowerName() {
		return towerName;
	}

	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}

	public String getSkillsCount() {
		return skillsCount;
	}

	public void setSkillsCount(String skillsCount) {
		this.skillsCount = skillsCount;
	}

	public String getTowerColor() {
		return towerColor;
	}

	public void setTowerColor(String towerColor) {
		this.towerColor = towerColor;
	}

	public String getSpiralTarget() {
		return spiralTarget;
	}

	public void setSpiralTarget(String spiralTarget) {
		this.spiralTarget = spiralTarget;
	}

	public String getTopManager1() {
		return topManager1;
	}

	public void setTopManager1(String topManager1) {
		this.topManager1 = topManager1;
	}

	public String getTopManager2() {
		return topManager2;
	}

	public void setTopManager2(String topManager2) {
		this.topManager2 = topManager2;
	}

	public String getGreenManager() {
		return greenManager;
	}

	public void setGreenManager(String greenManager) {
		this.greenManager = greenManager;
	}

	public String getRedManager() {
		return redManager;
	}

	public void setRedManager(String redManager) {
		this.redManager = redManager;
	}

	public String getFloorCount() {
		return floorCount;
	}

	public void setFloorCount(String floorCount) {
		this.floorCount = floorCount;
	}

	public String getOutlinedWindow() {
		return outlinedWindow;
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

	public List<Floor> getFloorDetails() {
		return floorDetails;
	}

	public void setFloorDetails(List<Floor> floorDetails) {
		this.floorDetails = floorDetails;
	}

	public List<Skill> getSkillDetails() {
		return skillDetails;
	}

	public void setSkillDetails(List<Skill> skillDetails) {
		this.skillDetails = skillDetails;
	}

}
