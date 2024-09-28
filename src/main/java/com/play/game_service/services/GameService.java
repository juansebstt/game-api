package com.play.game_service.services;

import com.play.game_service.commons.entities.Game;

import java.util.List;

// Interface defining the service layer for game-related operations
public interface GameService {

    // Method to fetch all games from the database
    List<Game> getAllGames();

    // Method to save a new game into the database
    Game savedGame(String userId, Game gameRequest);

    // Method to retrieve a game by its ID
    Game getGameById(String id);

    // Method to update an existing game using its ID
    Game updateGame(String id, Game gameRequest);

    // Method to delete a game by its ID
    void deleteGame(String id);
}
