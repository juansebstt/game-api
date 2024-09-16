package com.play.game_service.services.impl;

import com.play.game_service.commons.entities.Game;
import com.play.game_service.commons.exceptions.GameException;
import com.play.game_service.repositories.GameRepository;
import com.play.game_service.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game savedGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    @Override
    public Game updateGame(String id, Game gameRequest) {
        Game existingGame = this.getGameById(id);

        existingGame.setName(gameRequest.getName());
        return this.gameRepository.save(existingGame);

    }

    @Override
    public void deleteGame(String id) {
        Game existingGame = this.getGameById(id);
        this.gameRepository.delete(existingGame);
    }
}
