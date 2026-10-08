package com.sharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.UserDAO;
import com.sharma.dto.UserDTO;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO dao;
@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		dao.add(dto);
		return dto.getId();
	}
@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);

	}
@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);

	}
@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {

		return dao.findByPk(id);
	}

	
}
