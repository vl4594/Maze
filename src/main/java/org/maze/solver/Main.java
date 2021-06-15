/**
 *
 */
package org.maze.solver;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("===== Running Spring Boot Application to save princess Peach ====");
        System.out.println("=================================================================");
        System.out.println("Enter the size of the grid M");
        int m = Util.getGridSize();
        System.out.println("Enter the grid as the M number of strings");
        String[] grid = Util.getGrid(m);
        System.out.println("--------------------------------------------");
        Util.printGrid(grid);
        System.out.println("Game is on!!");
        try {
            System.out.println(new Game(grid, m).bfsPath());
        } catch (UnsupportedOperationException ex) {
            System.err.println("cannot start the game - source or destination is invalid");
        }

    }
}
