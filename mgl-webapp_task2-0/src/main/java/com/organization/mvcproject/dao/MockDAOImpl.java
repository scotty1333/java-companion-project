package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organizaion.bootcamp.mvcproject.api.dao.MockDAO;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class MockDAOImpl implements MockDAO{
	
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
			    	for (int i = 0; i < games.size(); i++ ) {
						if(game.getId().equals(games.get(i).getId())) {
						    return games.set(i, game);
						}
			    	}
			    } 
			} 
			
		    game.setId(++gameId);
	        games.add((GameImpl) game);
	        return game; 
		
		}
		
		
		public GameImpl findGameById(Long id) {
			
			//for each loop
			for (GameImpl g : games) {
				if(id.equals(g.getId())) {
					return g; 
				}
			}
			// if no game was found
			return null; 
		}

		public boolean deleteGame(Long id) {
				for(int i = 0; i < games.size(); i++) {
					if( id == games.get(i).getId()) {
						games.remove(games.get(i));
						return true; 
					}
				}
			return false;
		}

		
		public List<GameImpl> findGamesByGenre(String genre) {
			//for loop
			List<GameImpl> gamesOfGenre = new ArrayList<>();
				for(int i = 0; i < games.size(); i++) {
					if( genre == games.get(i).getGenre()) {
						gamesOfGenre.add(games.get(i));
					}
				}
				
				return (gamesOfGenre.isEmpty()) ? null : gamesOfGenre;
		}
		

}
