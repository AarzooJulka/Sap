package com.sap.repository;

import java.util.List;

import com.sap.seq.BaseEntity;
import com.sap.user.User;

public interface BaseRepository<T extends BaseEntity> {

	<S extends T> S save(S entity);

	List<T> findAll();

	T findById(Long id);

	void deleteAll(Iterable<? extends T> entities);

	User getByEmail(String email);

}
