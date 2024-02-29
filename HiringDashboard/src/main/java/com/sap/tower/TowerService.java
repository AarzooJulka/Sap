package com.sap.tower;

import org.springframework.web.multipart.MultipartFile;

import com.sap.service.BaseService;

public interface TowerService extends BaseService<Tower> {

	boolean importExcel(MultipartFile excel);

}
