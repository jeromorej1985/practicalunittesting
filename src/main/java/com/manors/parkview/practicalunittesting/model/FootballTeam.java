package com.manors.parkview.practicalunittesting.model;

import lombok.Data;

@Data
public class FootballTeam implements Comparable<FootballTeam> {
    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if (gamesWon < 0){
            throw new IllegalArgumentException("Illegal number of games won " + gamesWon + "]");
        }
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        return gamesWon - otherTeam.getGamesWon();
    }
}
