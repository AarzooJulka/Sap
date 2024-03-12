package com.sap.service;

import java.util.List;

import com.sap.seq.BaseEntity;

public interface BaseService<T extends BaseEntity> {

	T save(T entity);

	List<T> getAll();

	T getById(long id);

	void deleteAll(Iterable<? extends T> entities);
}
