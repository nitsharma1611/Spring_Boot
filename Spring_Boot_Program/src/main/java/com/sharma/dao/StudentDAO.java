package com.sharma.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import com.sharma.dto.StudentDTO;

@Repository
public class StudentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public long add(StudentDTO dto) {

		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(StudentDTO dto) {
		entityManager.merge(dto);

	}

	public void delete(long id) {
		StudentDTO dto = findByPk(id);

		entityManager.remove(dto);

	}

	public StudentDTO findByPk(long id) {
		StudentDTO dto = entityManager.find(StudentDTO.class, id);
		return dto;
	}

}
