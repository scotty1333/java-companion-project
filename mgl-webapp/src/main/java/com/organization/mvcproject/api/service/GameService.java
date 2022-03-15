package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.dao.MockDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

public interface GameService {

	List<Game> retrieveAllGames();
	
	List<Game> findGameByGenre(String genre);

	Game saveGame(GameImpl game);
	
	Game findGameById(long id);
	
	boolean deleteGame(long id);
	

}
