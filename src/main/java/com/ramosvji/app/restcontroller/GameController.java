package com.ramosvji.app.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ramosvji.app.restcontroller.dto.GameDto;
import com.ramosvji.app.restcontroller.dto.GamesDto;

@RestController
public interface GameController {

	public ResponseEntity<GameDto> save(final GameDto game);
	
	public ResponseEntity<GamesDto> getAll();
	
	public ResponseEntity<GameDto> getById(final String id);
	
	public ResponseEntity<Void> deleteById(final String id);
}
