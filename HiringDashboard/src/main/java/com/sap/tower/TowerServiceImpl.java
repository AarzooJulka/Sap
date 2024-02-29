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
			for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
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
		tower.setTarget(getStringValue(row.getCell(17)));
		List<Skill> skills = saveSkill(getStringValue(row.getCell(5)));
		List<Floor> floors = saveFloor(row);
		tower.setFloorDetails(floors);
		tower.setSkillDetails(skills);
		super.save(tower);
	}

	private String getStringValue(XSSFCell cell) {
		return cell != null ? cell.toString() : "";
	}

	private List<Floor> saveFloor(XSSFRow row) {
		List<Floor> savedFloors = new ArrayList<>();
		for (int i = 18; i < 43; i += 5) {
			Floor floor = new Floor(getStringValue(row.getCell(i)), getStringValue(row.getCell(i + 1)),
					getStringValue(row.getCell(i + 2)), getStringValue(row.getCell(i + 3)),
					getStringValue(row.getCell(i + 4)), "Floor " + ((i - 18) / 5 + 1));
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

}
