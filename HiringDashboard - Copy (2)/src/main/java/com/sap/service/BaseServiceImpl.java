package com.sap.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sap.repository.BaseRepository;
import com.sap.seq.BaseEntity;
import com.sap.seq.SequenceGenerator;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected Class<T> domainClass;
	protected BaseRepository<T> repository;

	@Autowired
	SequenceGenerator sequenceGenerator;

	public BaseServiceImpl(Class<T> domainClass, BaseRepository<T> repository) {
		this.repository = repository;
		this.domainClass = domainClass;
	}

	@Override
	public T save(T entity) {
		long currentSeq = sequenceGenerator.generateSequence(entity.getSequence());
		entity.setId(currentSeq);
		T savedEntity = repository.save(entity);
		logger.info("Save Entity : {}", domainClass);
		return savedEntity;
	}

	@Override
	public List<T> getAll() {
		logger.info("Get All Objects : {}", domainClass);
		return repository.findAll();
	}

	@Override
	public T getById(long id) {
		T getEntity = repository.findById(id);
		logger.info("Get Object by id : {}", id);
		return getEntity;
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		repository.deleteAll(entities);

	}

}