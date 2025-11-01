package com.durga.util;

import org.springframework.beans.BeanUtils;

import com.durga.dto.UserDto;
import com.durga.entity.UserEntity;

public class UserUtil {
	
	public static UserEntity convertToEntity(UserDto dto) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static UserDto convertToDto(UserEntity entity) {
		UserDto dto=new UserDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
