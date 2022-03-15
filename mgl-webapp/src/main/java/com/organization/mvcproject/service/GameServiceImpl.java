package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.MockDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private MockDAO MockDAOImpl;

	@Override
	public List<Game> retrieveAllGames() {
		return MockDAOImpl.findAllGames();
	}

	@Override
	public Game saveGame(GameImpl game) {
		return MockDAOImpl.saveGame(game);
	}
	
	@Override
	public Game findGameById(long id) {
		return MockDAOImpl.findGameById(id);
	}
	
	@Override
	public List<Game> findGameByGenre(String genre) {
		return MockDAOImpl.findGamesByGenre(genre);
	}
	
	@Override
	public boolean deleteGame(long id) {
		return MockDAOImpl.deleteGame(id);
	}


}