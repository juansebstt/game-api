package com.play.game_service.controller.impl;

import com.play.game_service.commons.entities.Game;
import com.play.game_service.controller.GameApi;
import com.play.game_service.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller implementation that handles HTTP requests for game-related actions
// This implements the GameApi interface, providing concrete implementations for the endpoints
//http://localhost:8080/swagger-ui/index.html
@RestController
public class GameController implements GameApi {
    private final GameService gameService; // Injects the GameService to handle business logic

    public GameController(GameService gameService) {
        this.gameService = gameService; // Constructor-based dependency injection
    }

    @Override
    public ResponseEntity<List<Game>> getAllGames() { // Fetch all games from the service
        List<Game> games = gameService.getAllGames(); // Return the created game with HTTP status 200
        return ResponseEntity.ok(games);
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game game){

        System.out.println(userId);

        var gameCreated = this.gameService.savedGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id){
        return ResponseEntity.ok(this.gameService.getGameById(id)); // Fetch game by ID
    }

    @Override
    public ResponseEntity<Game> updateGameById(String id, @RequestBody Game game){
        var updatedGame = this.gameService.updateGame(id, game); // Update game with the provided ID
        return ResponseEntity.ok(updatedGame); // Return the updated game with HTTP status 200
    }

    @Override
    public ResponseEntity<Void> deleteGameById(String id){
        this.gameService.deleteGame(id); // Delete the game with the provided ID
        return ResponseEntity.noContent().build(); // Return HTTP status 204 (No Content)
    }
}


