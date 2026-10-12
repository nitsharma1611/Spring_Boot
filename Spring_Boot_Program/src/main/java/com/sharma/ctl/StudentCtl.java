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
import com.sharma.dto.StudentDTO;
import com.sharma.dto.UserDTO;
import com.sharma.form.StudentForm;
import com.sharma.form.UserForm;
import com.sharma.service.StudentService;

@RestController
@RequestMapping("Student")
public class StudentCtl {
	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ORSResponse save(@RequestBody StudentForm form) {
		ORSResponse res = new ORSResponse();
		StudentDTO dto = (StudentDTO) form.getDto();
		studentService.add(dto);
		res.addMessage("Student add Successfully");
		return res;
	}

	@PostMapping("/update")
	public ORSResponse update(@RequestBody StudentForm form) {
		ORSResponse res = new ORSResponse();
		StudentDTO dto = (StudentDTO) form.getDto();
		studentService.update(dto);
		res.addMessage("Student update Successfully");
		return res;
	}

	@PostMapping("/delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {
		ORSResponse res = new ORSResponse();
		for (long id : ids) {
			studentService.delete(id);
			res.addMessage("Student deleted Successfully");
		}
		return res;
	}

	@GetMapping("/get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();

		StudentDTO dto = studentService.findByPk(id);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.addMessage("Record not Found");
		}

		return res;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/search/{pageNo}")
	public ORSResponse search(@RequestBody StudentForm form, @PathVariable int pageNo) {
		ORSResponse res = new ORSResponse();
		int pageSize = 5;
		StudentDTO dto = (StudentDTO) form.getDto();

		List<StudentDTO> list = studentService.search(dto, pageNo, pageSize);
		if (list != null) {
			res.addData(list);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}
		return res;
	}

}
