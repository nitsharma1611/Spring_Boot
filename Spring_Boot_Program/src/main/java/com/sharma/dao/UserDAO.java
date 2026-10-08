package com.sharma.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.dto.RoleDTO;
import com.sharma.dto.UserDTO;

@Repository
public class UserDAO {
	@Autowired
	private RoleDAO roleDao;
	@PersistenceContext
	private EntityManager entityManager;

	public long add(UserDTO dto) {
Long roleId=dto.getRoleId();
	
	RoleDTO roledto=roleDao.findByPk(roleId);
	String roleName= roledto.getName();
	dto.setRoleName(roleName);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {
		entityManager.merge(dto);

	}

	public void delete(long id) {
		UserDTO dto = findByPk(id);

		entityManager.remove(dto);

	}

	public UserDTO findByPk(long id) {
		UserDTO dto = entityManager.find(UserDTO.class, id);
		return dto;
	}
	
	
	
	/*public UserDTO findByLogin(String login) {
		 String jpql = "SELECT * FROM st_user  WHERE u.login = :login";

		UserDTO dto = entityManager.find(UserDTO.class, id);
		return dto;
	}
	public UserDTO authenticate(String login,String password) {
		UserDTO dto = entityManager.;
		return dto;
	}*/
}
