package com.sharma.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.common.ORSResponse;
import com.sharma.dto.UserDTO;
import com.sharma.form.LoginForm;
import com.sharma.form.UserRegistrationForm;
import com.sharma.service.UserService;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl {
	@Autowired
	public UserService userService;

	@PostMapping("signUp")
	public ORSResponse save(@RequestBody UserRegistrationForm form) {
		ORSResponse res = new ORSResponse();
		UserDTO dto = (UserDTO) form.getDto();
		long pk = userService.add(dto);
		res.addData(pk);
		res.addMessage("User Register successfully");
		res.setSuccess(true);

		return res;
	}

	@PostMapping("login")
	public ORSResponse save(@RequestBody LoginForm form, HttpSession session) {
		ORSResponse res = new ORSResponse();
		UserDTO dto = (UserDTO) form.getDto();
		dto = userService.authenticate(dto.getLogin(), dto.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			res.addMessage("User login successfully");
			res.setSuccess(true);
		} else {
			res.addMessage("invalid login or password");
		}
		return res;
	}

	@PostMapping("logout")
	public ORSResponse save(HttpSession session) {
		ORSResponse res = new ORSResponse();

		session.invalidate();
		res.addMessage("User logout successfully");

		return res;
	}

}
