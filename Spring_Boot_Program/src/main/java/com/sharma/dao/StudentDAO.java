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

import com.sharma.dto.StudentDTO;
import com.sharma.dto.UserDTO;

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

	public List<StudentDTO> search(StudentDTO dto, int pageNo, int PageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentDTO> cq = builder.createQuery(StudentDTO.class);
		Root<StudentDTO> qRoot = cq.from(StudentDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
			}
			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
				predicateList.add(builder.like(qRoot.get("mobileNo"), dto.getMobileNo() + "%"));
			}
			if (dto.getEmail() != null && dto.getEmail().length() > 0) {
				predicateList.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				predicateList.add(builder.equal(qRoot.get("dob"), dto.getDob() + "%"));
			}

		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		TypedQuery<StudentDTO> tq = entityManager.createQuery(cq);

		if (PageSize > 0) {
			tq.setFirstResult((pageNo - 1) * PageSize);
			tq.setMaxResults(PageSize);
		}
		List<StudentDTO> list = tq.getResultList();
		return list;
	}

}
