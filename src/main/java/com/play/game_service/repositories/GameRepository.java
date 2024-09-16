// JPA Repository interface for accessing Game entities from the database
package com.play.game_service.repositories;

import com.play.game_service.commons.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository provides CRUD operations for the Game entity
public interface GameRepository extends JpaRepository<Game, Long> {
}
