package ec.edu.ups.poo;

public class Maze {

    private boolean[][] maze;

    public Maze(boolean[][] maze) {
        this.maze = maze;
    }
    public void printMaze() {
        for (int i = 0;i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j]) {
                    System.out.print("- "); // Espacio libre
                } else {
                    System.out.print("* "); // Pared
                }
            }
            System.out.println();
        }

        System.out.println("Laberinto impreso correctamente.");
    }
    public boolean[][] getMaze() {
        return maze;
    }
}
