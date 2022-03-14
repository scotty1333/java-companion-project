package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.GameStreamBasedDAO;
import com.organization.mvcproject.model.GameImpl;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameStreamBasedDAO gameDAO; 

	@Override
	public List<GameImpl> retrieveAllGames() {
		return gameDAO.findAllGames();
	}

	@Override
	public GameImpl saveGame(GameImpl game) {
		return gameDAO.saveGame(game);
	}
	
	@Override
	public GameImpl findGameById(Long id) {
		return gameDAO.findGameById(id);
	}

	@Override
	public boolean deleteGame(Long id) {
		return gameDAO.deleteGame(id); 
	}
}
	