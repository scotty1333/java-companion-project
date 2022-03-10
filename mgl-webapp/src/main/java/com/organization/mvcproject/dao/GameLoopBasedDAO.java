package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;


@Repository
public class GameLoopBasedDAO {
	
	//Mock database through static declarations
	private static Long gameId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	public List<Game> findAllGames() {
		return games;
	}

	public Game saveGame(Game game) {
		if(game.getId() != null) {
			Game foundGame = findGameById(game.getId());
			if(foundGame != null) {
				//update the game in the list
				for(int i=0; i<games.size(); i++) {
					if(game.getId().equals(games.get(i).getId())) {
						return games.set(i, game);
					}
				}
			}
		}
		
		game.setId(++gameId);
		games.add(game);
		return game;
	}
	
	public Game findGameById(Long id) {
		for(Game g : games) {
			if(id.equals(g.getId())) {
				return g;
			}
		}
		//if no game found
		return null;
	}
	
	public boolean deleteGame(long id) {
		for(int i=0; i<games.size(); i++) {
			if(id == games.get(i).getId()) {
				games.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<Game> findGameByGenre(String genre) {
		List<Game> gamesByGenre = new ArrayList<>();
		for(int i=0; i<games.size(); i++) {
			if(genre.equals(games.get(i).getGenre())) {
				gamesByGenre.add(games.get(i));
			}
		}
		//if no game found
		return (gamesByGenre.isEmpty()) ? null : gamesByGenre;
	}
}
