package com.sharma.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.common.ORSResponse;

import com.sharma.dto.UserDTO;

import com.sharma.form.UserForm;

import com.sharma.service.UserService;

@RestController
@RequestMapping("User")
public class UserCtl {
	@Autowired
	private UserService userservice;

	@PostMapping("/save")
	public ORSResponse save(@RequestBody UserForm form) {
		ORSResponse res = new ORSResponse();
		UserDTO dto = (UserDTO) form.getDto();
		userservice.add(dto);
		res.addMessage("User add Successfully");
		return res;
	}

	@PostMapping("/update")
	public ORSResponse update(@RequestBody UserForm form) {
		ORSResponse res = new ORSResponse();
		UserDTO dto = (UserDTO) form.getDto();
		userservice.update(dto);
		res.addMessage("User update Successfully");
		return res;
	}

	@PostMapping("/delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {
		ORSResponse res = new ORSResponse();
		for (long id : ids) {
			userservice.delete(id);
			res.addMessage("User deleted Successfully");
		}
		return res;
	}

	@GetMapping("/get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();

		UserDTO dto = userservice.findByPk(id);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.addMessage("Record not Found");
		}

		return res;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/search/{pageNo}")
	public ORSResponse search(@RequestBody UserForm form, @PathVariable int pageNo) {
		ORSResponse res = new ORSResponse();
		int pageSize = 5;
		UserDTO dto = (UserDTO) form.getDto();

		List<UserDTO> list = userservice.search(dto, pageNo, pageSize);
		if (list != null) {
			res.addData(list);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}
		return res;
	}

}
