package com.ramosvji.app.service;

import org.springframework.stereotype.Service;

import com.ramosvji.app.service.dto.GameDtoInt;
import com.ramosvji.app.service.dto.GamesDtoInt;

@Service
public interface GameService {

	public GameDtoInt save(final GameDtoInt game);
	
	public GamesDtoInt getAll();
	
	public GameDtoInt getById(final String id);
	
	public void deleteById(final String id);
}
