package com.sap.tower;

public class Skill {

	private String skillName;
	private String skillCount;

	public Skill() {
		super();
	}

	public Skill(String skillName, String skillCount) {
		super();
		this.skillName = skillName;
		this.skillCount = skillCount;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillCount() {
		return skillCount;
	}

	public void setSkillCount(String skillCount) {
		this.skillCount = skillCount;
	}

}
