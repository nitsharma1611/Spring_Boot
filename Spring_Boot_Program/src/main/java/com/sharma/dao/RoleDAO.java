package com.sharma.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sharma.dto.RoleDTO;

@Repository
public class RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public long add(RoleDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(RoleDTO dto) {
		entityManager.merge(dto);

	}

	public void delete(long id) {
		RoleDTO dto = findByPk(id);

		entityManager.remove(dto);

	}

	public RoleDTO findByPk(long id) {
		RoleDTO dto = entityManager.find(RoleDTO.class, id);
		return dto;
	}

}
