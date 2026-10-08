package com.sharma.ctl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.common.ORSResponse;
import com.sharma.dto.RoleDTO;
import com.sharma.form.RoleForm;
import com.sharma.service.RoleService;

@RestController
@RequestMapping("Role")
public class RoleCtl {
	@Autowired
	private RoleService roleservice;

	@PostMapping("/save")
	public ORSResponse save(@RequestBody RoleForm form) {
		ORSResponse res = new ORSResponse();
		RoleDTO dto = (RoleDTO) form.getDto();
		roleservice.add(dto);
		res.addMessage( "Role add Successfully");
		return res;
	}

	@PostMapping("/update")
	public ORSResponse update(@RequestBody RoleForm form) {
		ORSResponse res = new ORSResponse();
		RoleDTO dto = (RoleDTO) form.getDto();
		roleservice.update(dto);
		res.addMessage("Role update Successfully");
		return res;
	}

	@PostMapping("/delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {
		ORSResponse res = new ORSResponse();
		for (long id : ids) {
			roleservice.delete(id);
			res.addMessage( "Role deleted Successfully");
		}
		return res;
	}

	@GetMapping("/get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();

		RoleDTO dto = roleservice.findByPk(id);
		if (dto != null) {
			res.addData(dto);
		} else {
		res.addMessage("Record not Found");
		}

		return res;
	}

}
