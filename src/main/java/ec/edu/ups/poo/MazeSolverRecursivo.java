package ec.edu.ups.poo;

import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo implements MazeSolver{
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if ( grid == null || grid.length == 0){
            return path;
        }
        if (findPath(grid, start, end, path)) {
            return path;
        }
        return path;
    }
    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        int fila = start.getRow();
        int columna = start.getCol();
        // Verificar si la celda actual es válida
        if ( fila >= grid.length || columna >= grid[0].length || !grid[fila][columna]) {
            return false; // Fuera de los límites o pared
        }
        if (columna == end.getCol() && fila == end.getRow()) {
            path.add(start); // Se ha encontrado el final
            return true;
        }
        if (findPath(grid, new Cell(columna + 1 ,fila), end, path)){
            path.add(start); // Agregar la celda actual al camino
            return true;
        }
        if (findPath(grid, new Cell(fila, columna + 1), end, path)){
            path.add(start); // Agregar la celda actual al camino
            return true;
        }
        return false;
    }
}
