package com.sap.tower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sap.service.BaseServiceImpl;

@Service
public class TowerServiceImpl extends BaseServiceImpl<Tower> implements TowerService {
	Logger logger = LoggerFactory.getLogger(TowerServiceImpl.class);

	public TowerServiceImpl(@Autowired TowerRepository repository) {
		super(Tower.class, repository);
	}

	@Override
	public boolean importExcel(MultipartFile excel) {
		List<Tower> towers = super.getAll();
		if (towers != null && !towers.isEmpty()) {
			super.deleteAll(towers);
		}
		boolean success = false;

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int i = 3; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				saveDetails(row);
			}
			success = true;
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}

		return success;

	}

	public void saveDetails(XSSFRow row) {
		Tower tower = new Tower();
		TowerData data = new TowerData();
		String cellValue = getStringValue(row.getCell(0));

		if (cellValue.startsWith("Tower")) {
			tower.setTowerNumber(getStringValue(row.getCell(0)));
			tower.setTowerName(getStringValue(row.getCell(1)));
			tower.setTowerColor(getStringValue(row.getCell(2)));
			tower.setSpiralTarget(getStringValue(row.getCell(3)));
			tower.setSkillsCount(getStringValue(row.getCell(4)));
			tower.setTopManager1(getStringValue(row.getCell(6)));
			tower.setTopManager2(getStringValue(row.getCell(7)));
			tower.setGreenManager(getStringValue(row.getCell(8)));
			tower.setRedManager(getStringValue(row.getCell(9)));
			tower.setFloorCount(getStringValue(row.getCell(10)));
			tower.setWindowCount(getStringValue(row.getCell(11)));
			tower.setOutlinedWindow(getStringValue(row.getCell(12)));
			tower.setEmptyWindow(getStringValue(row.getCell(13)));
			tower.setBrokenWindow(getStringValue(row.getCell(14)));
			tower.setIlluminatedWindow(getStringValue(row.getCell(15)));
			tower.setOccupiedWindow(getStringValue(row.getCell(16)));
			// tower.setTarget(getStringValue(row.getCell(17)));
			List<Skill> skills = saveSkill(getStringValue(row.getCell(5)));
			List<Floor> floors = saveFloor(row);
			tower.setFloorDetails(floors);
			tower.setSkillDetails(skills);
		}

		super.save(tower);
	}

	private String getStringValue(XSSFCell cell) {
		return cell != null ? cell.toString() : "";
	}

	private List<Floor> saveFloor(XSSFRow row) {
		List<Floor> savedFloors = new ArrayList<>();
		for (int i = 22; i < 46; i += 5) {
			Floor floor = new Floor(getStringValue(row.getCell(i)), getStringValue(row.getCell(i + 1)),
					getStringValue(row.getCell(i + 2)), getStringValue(row.getCell(i + 3)),
					getStringValue(row.getCell(i + 4)), "Floor " + ((i - 22) / 5 + 1));
			savedFloors.add(floor);
		}
		return savedFloors;
	}

	public List<Skill> saveSkill(String value) {
		List<Skill> savedSkills = new ArrayList<>();
		String[] skillCountPairs = value.split(",");
		for (String pair : skillCountPairs) {
			String[] parts = pair.trim().split("=");
			String skillName = parts[0].trim();
			String skillCount = parts[1].trim();
			Skill skill = new Skill(skillName, skillCount);
			savedSkills.add(skill);
		}
		return savedSkills;
	}

	public TowerDataWrapper getTower() {
		TowerDataWrapper dataWrapper = new TowerDataWrapper();
		List<Tower> towers = getAll();
		List<Tower> towerDetails = new ArrayList<>();
		List<String> topManagers = new ArrayList<>();
		TowerData data = new TowerData();
		double totalOnboarded = 0;
		double actualOnboarded = 0;
		double actualOfferAccepted = 0;
		double actualOfferReleased = 0;

		for (Tower tower : towers) {
			towerDetails.add(tower);
			topManagers.add(tower.getTopManager1());
			double spiralTarget = 0.0;
			double occupiedWindow = 0.0;
			double illuminated = 0.0;
			double empty = 0.0;

			try {
				spiralTarget = Double.parseDouble(tower.getSpiralTarget());
				occupiedWindow = Double.parseDouble(tower.getOccupiedWindow());
				illuminated = Double.parseDouble(tower.getIlluminatedWindow());
				empty = Double.parseDouble(tower.getEmptyWindow());
			} catch (NumberFormatException e) {
				e.getMessage();
			}
			totalOnboarded += spiralTarget;
			actualOnboarded += occupiedWindow;
			actualOfferAccepted += illuminated;
			actualOfferReleased += empty;

		}

		data.setTotalOnboarded(String.valueOf(totalOnboarded));
		data.setActualOnboarded(String.valueOf(actualOnboarded));
		data.setActualOfferAccepted(String.valueOf(actualOfferAccepted));
		data.setActualOfferReleased(String.valueOf(actualOfferReleased));
		data.setTotalOfferReleased(String.valueOf(Math.floor(actualOfferAccepted / 0.75)));
		data.setTotalOfferAccepted(String.valueOf(Math.floor(totalOnboarded / 0.85)));
		data.setTopManagers(topManagers);
		dataWrapper.setTowerDetails(towerDetails);
		dataWrapper.setTowerData(data);

		return dataWrapper;
	}
}
