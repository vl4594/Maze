/**
 SBE Vision code challenge
 candidate: Victor Lyamtsev
 */

package org.maze.solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maze.solver.Game;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTests {
    @Test
    void test_sbe_demo_case() {
        String grid[] = new String[7];
        grid[0] = "-----p-";
        grid[1] = "-*****-";
        grid[2] = "--b----";
        grid[3] = "**-----";
        grid[4] = "-------";
        grid[5] = "-******";
        grid[6] = "--m----";
        String res = new Game(grid, 7).bfsPath();
        assertEquals(res.trim(), "LEFT LEFT UP UP RIGHT RIGHT UP RIGHT UP RIGHT RIGHT RIGHT UP UP LEFT");
    }
    @Test
    void test_obvious_path() {
        String grid[] = new String[3];
        grid[0] = "m**";
        grid[1] = "--p";
        grid[2] = "***";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "DOWN RIGHT RIGHT");
    }

    @Test
    void test_singleStep_right() {
        String grid[] = new String[3];
        grid[0] = "***";
        grid[1] = "***";
        grid[2] = "mp*";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "RIGHT");
    }

    @Test
    void test_singleStep_left() {
        String grid[] = new String[3];
        grid[0] = "***";
        grid[1] = "***";
        grid[2] = "pm*";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "LEFT");
    }

    @Test
    void test_singleStep_up() {
        String grid[] = new String[3];
        grid[0] = "***";
        grid[1] = "p**";
        grid[2] = "m**";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "UP");
    }

    @Test
    void test_singleStep_down() {
        String grid[] = new String[3];
        grid[0] = "***";
        grid[1] = "m**";
        grid[2] = "p**";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "DOWN");
    }

    @Test
    void test_path_IsShortest() {
        String grid[] = new String[3];
        grid[0] = "--p";
        grid[1] = "---";
        grid[2] = "--m";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "UP UP");
    }

    @Test
    void test_return_forFailure() {
        String grid[] = new String[3];
        grid[0] = "**p";
        grid[1] = "***";
        grid[2] = "m**";
        assertEquals(new Game(grid, 3).bfsPath().trim(), "");
    }

    @Test
    void test_missingHero_throwsExeption() {
        String grid[] = new String[3];
        grid[0] = "**p";
        grid[1] = "***";
        grid[2] = "***";
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            new Game(grid, 3).bfsPath();
        });
    }

    @Test
    void test_missingPrincess_throwsException (){
        String grid[] = new String[3];
        grid[0] = "***";
        grid[1] = "***";
        grid[2] = "m**";
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            new Game(grid, 3).bfsPath();
        });
    }

}