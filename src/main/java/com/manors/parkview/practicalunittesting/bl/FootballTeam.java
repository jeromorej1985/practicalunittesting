package com.manors.parkview.practicalunittesting.bl;

public class FootballTeam {
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
}
