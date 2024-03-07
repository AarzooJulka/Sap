package com.sap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.sap.seq.BaseEntity;

public class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository<T> {
	@Autowired
	private MongoTemplate mongoTemplate;

	protected Class<T> domainClass;

	public BaseRepositoryImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	@Override
	public <S extends T> S save(S entity) {
		return mongoTemplate.save(entity);
	}

	@Override
	public T findById(Long id) {
		T obj = mongoTemplate.findById(id, domainClass);
		return obj;
	}

	@Override
	public List<T> findAll() {
		List<T> listT = null;
		listT = mongoTemplate.find(new Query(), domainClass);
		return listT;
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		for (T object : entities) {
			mongoTemplate.remove(object);

		}
	}

}
