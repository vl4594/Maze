/**
 */
package org.maze.solver;

/**
 * class Point
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return ("x=" + this.x + " y=" + this.y);
    }
}
