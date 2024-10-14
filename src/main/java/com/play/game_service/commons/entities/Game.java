package com.play.game_service.commons.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")  // Specifies that this class is mapped to the 'games' table in the database
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates the ID values for each game
    private Long id; // Primary key for the Game entity

    private String name; // The name of the game
    private String userId;
}
