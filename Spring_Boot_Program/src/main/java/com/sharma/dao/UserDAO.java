package com.sharma.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharma.common.ORSResponse;
import com.sharma.dto.RoleDTO;
import com.sharma.dto.UserDTO;

@Repository
public class UserDAO {
	@Autowired
	private RoleDAO roleDao;
	@PersistenceContext
	private EntityManager entityManager;

	public long add(UserDTO dto) {

		RoleDTO roledto = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roledto.getName());
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

	public List<UserDTO> search(UserDTO dto, int pageNo, int PageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);
		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				predicateList.add(builder.like(qRoot.get("login"), dto.getLogin() + "%"));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				predicateList.add(builder.like(qRoot.get("password"), dto.getPassword() + "%"));
			}

			if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("roleName"), dto.getRoleName() + "%"));
			}
		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		if (PageSize > 0) {
			tq.setFirstResult((pageNo - 1) * PageSize);
			tq.setMaxResults(PageSize);
		}
		List<UserDTO> list = tq.getResultList();
		return list;
	}
}
