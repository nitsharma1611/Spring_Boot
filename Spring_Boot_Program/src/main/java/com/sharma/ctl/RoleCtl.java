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
import com.sharma.form.RoleForm;
import com.sharma.service.RoleService;

@RestController
@RequestMapping("Role")
public class RoleCtl {
	@Autowired
	private RoleService roleservice;

	@PostMapping("/save")
	public Map save(@RequestBody RoleForm form) {
		Map m = new HashMap();
		RoleDTO dto = (RoleDTO) form.getDto();
		roleservice.add(dto);
		m.put("msg", "Role add Successfully");
		return m;
	}

	@PostMapping("/update")
	public Map update(@RequestBody RoleForm form) {
		Map m = new HashMap();
		RoleDTO dto = (RoleDTO) form.getDto();
		roleservice.update(dto);
		m.put("msg", "Role update Successfully");
		return m;
	}

	@PostMapping("/delete/{ids}")
	public Map delete(@PathVariable long[] ids) {
		Map m = new HashMap();
		for (long id : ids) {
			roleservice.delete(id);
			m.put("msg", "Role deleted Successfully");
		}
		return m;
	}

	@GetMapping("/get/{id}")
	public Map get(@PathVariable long id) {
		Map m = new HashMap();

		RoleDTO dto = roleservice.findByPk(id);
		if (dto != null) {
			m.put("data", dto);
		} else {
			m.put("msg", "Record not Found");
		}

		return m;
	}

}
