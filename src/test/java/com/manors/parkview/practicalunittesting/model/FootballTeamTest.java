package com.manors.parkview.practicalunittesting.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
    private static final int THREE_GAMES_WON = 3;
    private static final int ANY_NUMBER = 123;

    public Object[] nboGamesWon(){
        return new Object[][]{{1}, {11}, {5}};
    }

    @Test
    @Parameters(method = "nboGamesWon")
    public void constructorShouldSetGamesWon(int nboGamesWon) {
        FootballTeam team = new FootballTeam(nboGamesWon);

        assertEquals(nboGamesWon + " games passed to constructor, but " + team.getGamesWon() + " were returned.", nboGamesWon, team.getGamesWon());
    }

    public Object[]  illegalNbOfGamesWon(){
        return new Object[][]{{-1}, {-19}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNbOfGamesWon")
    public void constructonShouldThrowExceptionForIllegalGamesWon(int illegalNbOfGames){
        new FootballTeam(illegalNbOfGames);
    }

    @Test
    public void shouldBePossibleToCompareTeams(){
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertTrue("FootballTeam should implement Comparable", team instanceof Comparable);
    }

    @Test
    public void teamsWithMoreMatchesWonShouldBeGreater(){
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(THREE_GAMES_WON);

        assertTrue("Team with 3 games won should be ranked higher than team with 2 games won", team_3.compareTo(team_2) > 0);
    }

    @Test
    public void teamsWithLessMatchesWonShouldBeRankedLower(){
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(THREE_GAMES_WON);

        assertTrue(String.format("teams with %d games won should be ranked lower than team with %d games won" , team_2.getGamesWon(), team_3.getGamesWon()), team_2.compareTo(team_3) < 0);
    }

    @Test
    public void teamsWithTheSameNumberOfMatchesWonShouldBeEqual(){
        FootballTeam teamA = new FootballTeam(THREE_GAMES_WON);
        FootballTeam teamB = new FootballTeam(THREE_GAMES_WON);

        assertTrue(String.format("Both teams have won the same amount of matches: %d vs. %d and should be ranked the equally", teamA.getGamesWon(), teamB.getGamesWon()), teamA.compareTo(teamB) == 0);
    }
}
