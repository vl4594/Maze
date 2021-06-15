/**

 */
package org.maze.solver;

import java.util.*;
/**
    utility class
 */
public class Util {
    /**
     * read grid size from stdin
     */
    public static int getGridSize(){
        int num = -1;
        Scanner in = null;
        while(num < 1) {
            in = new Scanner(System.in);
            in.useDelimiter("\n");
            try {
                num = in.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("Illegal number input, try again");
                num = -1;
                continue;
            }
            if (num < 3 || num > 100) {
                System.err.println("Grid size cannot be < 3 or > 100");
                num = -1;
                continue;
            }
        }
        return num;
    }

    /**
     * method to insure only valid characters in the line of user input
     * @param s
     * @param m
     * @return true if string is valid, false otherwise
     */
    public static boolean validateString(String s, int m) {
        Set<Character> valid = new HashSet<Character>(Arrays.asList('-', 'b','p','m','*'));
        for (int i=0; i < m; i++) {
            if (!valid.contains(s.charAt(i))) {
                System.err.println("invalid character: "+ s.charAt(i) +
                        "at pos " + i);
                System.err.println("only one of the following characters allowed: - b p m *");
                return false;
            }
        }
        return true;
    }

    /**
     * read game grid from stdin
     * @param dim
     * @return grid as array of strings
     */
    public static String[] getGrid(int dim) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String grid[] = new String[dim];
        for(int y = 0; y < dim; y++) {
                grid[y] = in.next();
                if (grid[y].length() < dim) {
                    System.out.println("line too short : " + grid[y].length() + " try again");
                    y--;
                    continue;
                }
                else if (grid[y].length() > dim) {
                    grid[y] = grid[y].substring(0, dim);
                }
                if (!validateString(grid[y], dim)) {
                    System.err.println("line contains invalid characters, try again");
                    y--;
                    continue;
                }

        }
        return grid;
    }

    /**
     * print grid
     * @param gridStrings
     */
    public static void printGrid(String[] gridStrings) {
        for(int i=0; i < gridStrings.length; i++) {
            System.out.println(gridStrings[i]);
        }
    }
}
