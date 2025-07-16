package ec.edu.ups.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        runFibonacciExample();
        runMaze();


    }
    public static void runFibonacciExample() {
        EjerciciosPD ejercicios = new EjerciciosPD();
        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        long resultado = ejercicios.getFibonacci(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado: " + resultado + ", Tiempo: " + duration);

        System.out.println("Fibonacci Recursivo Caching");
        start = System.nanoTime();
        resultado = ejercicios.getFibonacciPD(50);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado: " + resultado + ", Tiempo: " + duration);

    }

    private static void runMaze(){
        boolean [][] maze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, false, false, false},
            {true, true, true, true}
        };
        Maze m = new Maze(maze);
        System.out.println("Solucionando el laberinto:");
        m.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursivo2(),
            new MazeSolverRecursivo()
        );
        MazeSolver solver = solvers.get(1);
        List<Cell> path = solver.getPath(maze, start, end);

        System.out.println("\nCamino encontrado: ");
        System.out.println("Matriz: " + path);
        solver = solvers.get(1);
        path = solver.getPath(maze, start, end);

        System.out.println("\nCamino encontrado (4 direcciones)");
        if (path.isEmpty()) {
            System.out.println("No se encontró camino");
        } else {
            System.out.println(path);
        }

    }
}