package com.organization.mvcproject.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.GameImpl;

@Repository
public class GameStreamBasedDAO  {
	
	/*
	 *  These static declarations allow us to mock a database. 
	 */
	private static Long gameId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	/*
	 *  end static declarations
	 */
	
	
	public List<GameImpl> findAllGames() {
		return games;
	}

	
	public GameImpl saveGame(GameImpl game) {
		if( game.getId() != null) {
			GameImpl foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	games = games.stream()
		    		    .map(g -> g.getId().equals(game.getId()) ? (GameImpl) game : g)
		    		    .collect(Collectors.toList());
		    	return game; 
		    } 
		} 
		
	    game.setId(++gameId);
        games.add((GameImpl) game);
        return game; 
	
	}
	
	
	public GameImpl findGameById(Long id) {
		return games.stream()
				  .filter(game -> id.equals(game.getId()))
				  .findAny()
				  .orElse(null);
	}

	public boolean deleteGame(Long id) {
		return games.removeIf(game -> id.equals(game.getId()));
	}

	
	public List<GameImpl> findGamesByGenre(String genre) {
		return games.stream()
				  .filter(game -> genre.equals(game.getGenre()))
				  .collect(Collectors.toList());
	}
	
	
}