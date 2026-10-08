package com.sharma.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.dto.RoleDTO;
import com.sharma.dto.UserDTO;
import com.sharma.form.RoleForm;
import com.sharma.form.UserForm;
import com.sharma.service.RoleService;
import com.sharma.service.UserService;

@RestController
@RequestMapping("user")
public class UserCtl {
	@Autowired
	private UserService userservice;

	@PostMapping("/save")
	public Map save(@RequestBody UserForm form) {
		Map m = new HashMap();
		UserDTO dto = (UserDTO) form.getDto();
		userservice.add(dto);
		m.put("msg", "User add Successfully");
		return m;
	}

	@PostMapping("/update")
	public Map update(@RequestBody UserForm form) {
		Map m = new HashMap();
		UserDTO dto = (UserDTO) form.getDto();
		userservice.update(dto);
		m.put("msg", "User update Successfully");
		return m;
	}

	@PostMapping("/delete/{ids}")
	public Map delete(@PathVariable long[] ids) {
		Map m = new HashMap();
		for (long id : ids) {
			userservice.delete(id);
			m.put("msg", "User deleted Successfully");
		}
		return m;
	}

	@GetMapping("/get/{id}")
	public Map get(@PathVariable long id) {
		Map m = new HashMap();

		UserDTO dto = userservice.findByPk(id);
		if (dto != null) {
			m.put("data", dto);
		} else {
			m.put("msg", "Record not Found");
		}

		return m;
	}

}
