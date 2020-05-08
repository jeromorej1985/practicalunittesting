package com.manors.parkview.practicalunittesting.bl;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
    private static final int THREE_GAMES_WON = 3;

    public Object[] nboGamesWon(){
        return $(1, 1, 2);
    }

    @Test
    @Parameters(method = "nboGamesWon")
    public void constructorShouldSetGamesWon(int nboGamesWon) {
        FootballTeam team = new FootballTeam(nboGamesWon);

        assertEquals(nboGamesWon + " games passed to constructor, but " + team.getGamesWon() + " were returned.", nboGamesWon, team.getGamesWon());
    }

    public Object[]  illegalNbOfGamesWon(){
        return $(-1, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNbOfGamesWon")
    public void constructonShouldThrowExceptionForIllegalGamesWon(int illegalNbOfGames){
        new FootballTeam(illegalNbOfGames);
    }
}
