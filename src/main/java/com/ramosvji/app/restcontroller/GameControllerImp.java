package com.ramosvji.app.restcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramosvji.app.restcontroller.dto.GameDto;
import com.ramosvji.app.restcontroller.dto.GamesDto;
import com.ramosvji.app.service.GameService;
import com.ramosvji.app.service.dto.GameDtoInt;
import com.ramosvji.app.service.dto.GamesDtoInt;

@RestController
@RequestMapping(path="/ramosvji/api/games")
public class GameControllerImp implements GameController {
	
	@Autowired
	private GameService service;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
	@PostMapping(path="/v1/games")
	public ResponseEntity<GameDto> save(final @RequestBody GameDto game) {
		
		
		GameDtoInt gameDtoInt = service.save(mapper.map(game, GameDtoInt.class));
		GameDto out = mapper.map(gameDtoInt, GameDto.class);
		
		return new ResponseEntity<GameDto>(out, new HttpHeaders(), HttpStatus.CREATED);	
	}

	@Override
	@GetMapping(path="/v1/games")
	public ResponseEntity<GamesDto> getAll() {
		
		GamesDtoInt gamesDtoInt = service.getAll();
		
		GamesDto out = mapper.map(gamesDtoInt, GamesDto.class);
		
		return new ResponseEntity<GamesDto>(out, new HttpHeaders(), HttpStatus.CREATED);	
	}

	@Override
	@GetMapping(path="/v1/games/{id}")
	public ResponseEntity<GameDto> getById(final @PathVariable String id) {
		
		GameDtoInt gameDtoInt = service.getById(id);
		
		GameDto out = mapper.map(gameDtoInt, GameDto.class);
		
		return new ResponseEntity<GameDto>(out, new HttpHeaders(), HttpStatus.CREATED);
	}

	@Override
	@DeleteMapping(path="/v1/games/{id}")
	public ResponseEntity<Void> deleteById(final @PathVariable String id) {
		
		service.deleteById(id);
		return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);	
	}

}
