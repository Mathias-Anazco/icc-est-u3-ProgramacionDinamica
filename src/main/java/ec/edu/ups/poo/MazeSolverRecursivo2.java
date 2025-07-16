package ec.edu.ups.poo;

import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo2 implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return path;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (findPath(grid, start, end, path, visited)) {
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path, boolean[][] visited) {
        int fila = start.getRow();
        int columna = start.getCol();

        if (fila < 0 || fila >= grid.length || columna < 0 || columna >= grid[0].length ||
                !grid[fila][columna] || visited[fila][columna]) {
            return false;
        }

        visited[fila][columna] = true;

        if (fila == end.getRow() && columna == end.getCol()) {
            path.add(start);
            return true;
        }

        if (findPath(grid, new Cell(fila + 1, columna), end, path, visited) ||
                findPath(grid, new Cell(fila, columna + 1), end, path, visited) ||
                findPath(grid, new Cell(fila - 1, columna), end, path, visited) ||
                findPath(grid, new Cell(fila, columna - 1), end, path, visited)) {
            path.add(start);
            return true;
        }

        visited[fila][columna] = false;
        return false;
    }
}
