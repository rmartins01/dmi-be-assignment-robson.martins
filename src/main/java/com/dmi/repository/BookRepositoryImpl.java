package com.dmi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl /*implements StaticResourceRepository*/ {

	@PersistenceContext
	EntityManager entityManager;
/*
	private Criteria getCriteria() {
		return entityManager.unwrap(Session.class).createCriteria(StaticResource.class);
	}

	@Override
	public List<StaticResource> findAll() {
		Criteria criteria = getCriteria();
		return criteria.list();
	}*/
}