package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.GameDAO;
import com.organization.mvcproject.model.GameImpl;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO gameDAO;

	@Override
	public List<GameImpl> retrieveAllGames() {
		return gameDAO.findAllGames();
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		return gameDAO.saveGame(game);
	}
	
	public GameImpl findGameById(long id) {
		return gameDAO.findGameById(id);
	}
	
	public List<GameImpl> findGameByGenre(String genre) {
		return gameDAO.findGameByGenre(genre);
	}
	
	public boolean deleteGame(long id) {
		return gameDAO.deleteGame(id);
	}


}