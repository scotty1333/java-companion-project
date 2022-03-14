package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.GameDAO;
import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO gameDAO;

	@Override
	public List<Game> retrieveAllGames() {
		return gameDAO.findAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	public Game findGameById(long id) {
		return gameDAO.findGameById(id);
	}
	
	public List<Game> findGameByGenre(String genre) {
		return gameDAO.findGameByGenre(genre);
	}
	
	public boolean deleteGame(long id) {
		return gameDAO.deleteGame(id);
	}


}