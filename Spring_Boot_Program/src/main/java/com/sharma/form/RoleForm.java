package com.sharma.form;

import com.sharma.common.BaseDTO;
import com.sharma.common.BaseForm;
import com.sharma.dto.RoleDTO;

public class RoleForm extends BaseForm {

	private String name;
	private String description;
	              
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {
		RoleDTO dto=(RoleDTO)initDTO(new RoleDTO());
		dto.setName(name);
		dto.setDescription(description);
				return dto;
	}

}
