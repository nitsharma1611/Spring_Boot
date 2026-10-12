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

	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// select * from RoleDTO where 1=1
		CriteriaQuery<RoleDTO> cq = builder.createQuery(RoleDTO.class);

		Root<RoleDTO> qRoot = cq.from(RoleDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getName() != null && dto.getName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				predicateList.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
			}
		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<RoleDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<RoleDTO> list = tq.getResultList();
		return list;

	}

}
