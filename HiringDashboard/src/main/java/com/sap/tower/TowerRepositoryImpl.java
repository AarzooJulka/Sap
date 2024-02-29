package com.sap.tower;

import org.springframework.stereotype.Repository;

import com.sap.repository.BaseRepositoryImpl;

@Repository
public class TowerRepositoryImpl extends BaseRepositoryImpl<Tower> implements TowerRepository {

	public TowerRepositoryImpl() {
		super(Tower.class);
	}
}