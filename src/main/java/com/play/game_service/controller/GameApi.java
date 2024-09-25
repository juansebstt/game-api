package com.play.game_service.controller;

import com.play.game_service.commons.constants.ApiPathVariables;
import com.play.game_service.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API definition for game-related operations.
// All endpoints are prefixed with /v1/games as defined in ApiPathVariables
//localhost:8080/v1/games
@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {

    @GetMapping// Endpoint to fetch all games
    ResponseEntity<List<Game>> getAllGames();

    @PostMapping// Endpoint to save a new game
    ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game game);

    @GetMapping("/{id}") // Endpoint to fetch a specific game by its ID
    ResponseEntity<Game> getGameById(@PathVariable String id);

    @PutMapping({"/{id}"}) // Endpoint to update an existing game by ID
    ResponseEntity<Game> updateGameById(@PathVariable String id, @RequestBody Game game);

    @DeleteMapping({"/{id}"})// Endpoint to delete a game by its ID
    ResponseEntity<Void> deleteGameById(@PathVariable String id);
}
