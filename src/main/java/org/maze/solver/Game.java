/**
 *
 */
package org.maze.solver;

import java.util.*;

/**
 * class Game
 */
public class Game {
    final static int rowNum[] = {-1, 0, 0, 1};
    final static int colNum[] = {0, -1, 1, 0};
    private char[][] m_grid;
    private Point m_src;
    private Point m_dest;
    private int m_dim;
    boolean[][] visited;

    public Game(String[] input, int dim) {
        m_dim = dim;
        m_grid = new char[dim][dim];
        for (int y = 0; y < dim; y++) {
            for (int x = 0; x < input.length; x++) {
                m_grid[y][x] = input[y].charAt(x);
                if (m_grid[y][x] == 'p') m_dest = new Point(x, y);
                if (m_grid[y][x] == 'm') m_src = new Point(x, y);

            }
        }
    }

    /**
     * method to return distance from point in grid to destination
     */
    private int distance(Point p) {
        return (int) (Math.pow(p.x - m_dest.x, 2) + Math.pow(p.y - m_dest.y,2));
    }


    /**
     * class to represent cell in grid
     */
    static class Node {
        Point pt;
        int dist;

        public Node(Point pt) {
            this.pt = pt;
            this.dist = Integer.MAX_VALUE;
        }

        public Node(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
        public int getDist() {return dist;}
    }

    /**
     * check if node is not outside of grid
     */
    private boolean isValid(int row, int col) {
        return (row >= 0) && (row < m_dim) &&
                (col >= 0) && (col < m_dim);
    }

    /**
     * method nextCell returns Node adjacent to the current one with minimal distance to destination
     */
    private Node nextNode(Point pt) {

        List<Node> adjCells = new ArrayList<>();
        visited[pt.y][pt.x] = true;

        for (int i = 0; i < 4; i++) {
            int row = pt.x + rowNum[i];
            int col = pt.y + colNum[i];
            if (isValid(row, col) &&
                    m_grid[col][row] != '*' && m_grid[col][row] != 'b' &&
                    !visited[col][row]) {
                Point p = new Point(row, col);
                adjCells.add(new Node(p, distance(p)));
            }

        } //end for

        return (adjCells.size() == 0) ? null :
                adjCells.stream().min(Comparator.comparing(Node::getDist)).orElseThrow(NoSuchElementException::new);
    }

    /**
     * create string with steps to destination from stack
     * @param stack
     * @return String
     */
    private String stepsToDestination(Stack<Node> stack) {
        Node[] arr = new Node[stack.size()];
        arr = stack.toArray(arr);
        String result = "";
        for (int i = 1; i < stack.size(); i++) {
            result = result + " " + getMove(arr[i].pt, arr[i - 1].pt);
        }
        result.trim();
        return result;
    }

    /**
     * method to return steps from source to destination based on Lee algorithm
     */
    String bfsPath() {
        String printSteps = "";
        try {
            if (m_grid[m_src.y][m_src.x] != 'm' ||
                    m_grid[m_dest.y][m_dest.x] != 'p') {
                System.err.println("cannot start the game - source or destination is invalid");
            }
        } catch (NullPointerException npe) {
            throw new UnsupportedOperationException("cannot start the game - source or destination is invalid");
        }
        visited = new boolean[m_dim][m_dim];
        visited[m_src.y][m_src.x] = true;
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(m_src));

        while (!stack.isEmpty()) {
            Node curr = stack.peek();
            Point currentPoint = curr.pt;

            if (currentPoint.x == m_dest.x && currentPoint.y == m_dest.y) {
                // princess found - print steps
                printSteps = stepsToDestination(stack).trim();
                break;
            }
            Node next = nextNode(currentPoint);
            if (next != null) {
                stack.add(next);
                visited[next.pt.y][next.pt.x] = true;
            } else {
                //dead-end - go to the previous node
                stack.pop();
            }
        }

        return printSteps;
    }

    /**
     * method to return move between adjacent cells
     */
    private String getMove(Point pCurrent, Point pPrev) {
        String move = "INVALID";
        if (pCurrent.x == pPrev.x) {
            if (pCurrent.y < pPrev.y)
                move = "UP";
            else if (pCurrent.y > pPrev.y)
                move = "DOWN";
        } else if (pCurrent.y == pPrev.y) {
            if (pCurrent.x < pPrev.x)
                move = "LEFT";
            else if (pCurrent.x > pPrev.x)
                move = "RIGHT";
        }
        return move;
    }

};
