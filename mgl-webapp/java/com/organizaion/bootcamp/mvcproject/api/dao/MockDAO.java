package com.organizaion.bootcamp.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface MockDAO {
	
	
	GameImpl saveGame(GameImpl game);
	
	List<GameImpl> findAllGames();
	
	GameImpl findGameById(Long id);
	
	List<GameImpl> findGamesByGenre(String genre);
	
	boolean deleteGame(Long id);
}
