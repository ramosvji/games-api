package com.ramosvji.app.restcontroller.dto;

import java.io.Serializable;
import java.util.List;

public class GamesDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<GameDto> games;

	public List<GameDto> getGames() {
		return games;
	}

	public void setGames(List<GameDto> games) {
		this.games = games;
	}
	
}
