package com.sap.tower;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/tower")
public class TowerController {
	Logger logger = LoggerFactory.getLogger(TowerController.class);
	@Autowired
	TowerService towerService;

	@PostMapping("/excel")
	@CrossOrigin
	public ResponseEntity<String> excelReader(@RequestParam("file") MultipartFile excel) {
		// Assuming towerService.importExcel(excel) returns true if successful
		if (towerService.importExcel(excel)) {
			return ResponseEntity.ok().body("{\"message\": \"Successfully added the data\"}");
		} else {
			return ResponseEntity.badRequest().body("{\"message\": \"Failed to add the data\"}");
		}
	}

	@GetMapping()
	@CrossOrigin
	public List<Tower> getAllTowers() {
		List<Tower> towers = towerService.getAll();
		return towers;
	}

}
