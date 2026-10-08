package com.sharma.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.RoleDAO;
import com.sharma.dto.RoleDTO;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleDAO dao;
@Transactional(propagation = Propagation.REQUIRED)
	public long add(RoleDTO dto) {
		dao.add(dto);
		return dto.getId();
	}
@Transactional(propagation = Propagation.REQUIRED)
	public void update(RoleDTO dto) {
		dao.update(dto);

	}
@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);

	}
@Transactional(readOnly = true)
	public RoleDTO findByPk(long id) {

		return dao.findByPk(id);
	}

	
}
