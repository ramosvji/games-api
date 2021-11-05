package com.ramosvji.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramosvji.app.repository.GameRepository;
import com.ramosvji.app.repository.entity.Game;
import com.ramosvji.app.service.dto.GameDtoInt;
import com.ramosvji.app.service.dto.GamesDtoInt;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRepository repository;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
	public GameDtoInt save(final GameDtoInt gameDtoInt) {
		
		Game game = mapper.map(gameDtoInt, Game.class);
		
		game = repository.save(game);
		
		GameDtoInt out = mapper.map(game, GameDtoInt.class);
		
		return out;
	}

	@Override
	public GamesDtoInt getAll() {
		List<Game> games = repository.findAll();
		List<GameDtoInt> gamesDtoInt = new ArrayList<>();
		
		
		for(Game game: games) {
			gamesDtoInt.add(mapper.map(game, GameDtoInt.class));
		}
		GamesDtoInt out = new GamesDtoInt();
		out.setGames(gamesDtoInt);
		
		return out;
	}

	@Override
	public GameDtoInt getById(final String id) {
		Optional<Game> optional = repository.findById(id);
		GameDtoInt gameDtoInt = null;
		
		if(optional.isPresent()) {
			gameDtoInt = mapper.map(optional.get(), GameDtoInt.class);
		}
		
		return gameDtoInt;
	}

	@Override
	public void deleteById(final String id) {
		repository.deleteById(id);
	}

}
