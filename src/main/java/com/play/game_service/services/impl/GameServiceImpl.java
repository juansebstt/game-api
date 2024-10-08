package com.play.game_service.services.impl;

import com.play.game_service.commons.constants.TopicConstants;
import com.play.game_service.commons.entities.Game;
import com.play.game_service.commons.exceptions.GameException;
import com.play.game_service.repositories.GameRepository;
import com.play.game_service.services.GameService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final StreamBridge streamBridge;

    public GameServiceImpl(GameRepository gameRepository, StreamBridge streamBridge) {
        this.gameRepository = gameRepository;
        this.streamBridge = streamBridge;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game savedGame(String userId, Game gameRequest) {

        gameRequest.setUserId(userId);
        return Optional.of(gameRequest)
                .map(gameRepository::save)
                .map(this::sendGameEvent)
                .orElseThrow(() -> new GameException(HttpStatus.BAD_REQUEST, "Error saving game"));

    }

    private Game sendGameEvent(Game game) {

        Optional.of(game)
                .map(givenGame -> this.streamBridge.send(TopicConstants.GAME_CREATED_TOPIC, game))
                .map(bool -> game);

        return game;

    }

    @Override
    public Game getGameById(String id) {

        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));

    }

    @Override
    public Game updateGame(String id, Game gameRequest) {

        return Optional.of(gameRequest)
                .filter(game -> this.gameRepository.existsById(Long.valueOf(id)))
                .map(game -> {
                    game.setId(Long.valueOf(id));
                    return this.gameRepository.save(game);
                })
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));

    }

    @Override
    public void deleteGame(String id) {

        Game existingGame = this.getGameById(id);
        this.gameRepository.delete(existingGame);

    }
}
