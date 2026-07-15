import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Maze {

    public static void main(String[] args) {
        new Maze();
    }

    private int[][] maze;

    public Maze() {

        maze = new int[][] {
            {0, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0},
        };

        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(2, 0);

        List<Celda> camino = new ArrayList<>();
        Set<Celda> celdasVisitadas = new HashSet<>(); // Set para registrar las visitadas

        System.out.println("LABERINTO ORIGINAL");
        imprimirLaberinto();

        // Pasamos el Set al método findPath
        boolean encontrado = findPath(maze, inicio, fin, camino, celdasVisitadas);

        if (encontrado) {

            System.out.println("\nCAMINO ENCONTRADO:");

            for (int i = 0; i < camino.size(); i++) {
                Celda c = camino.get(i);
                System.out.print("(" + c.getX() + "," + c.getY() + ")");
                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println("\n");
            System.out.println("LABERINTO CON EL CAMINO FINAL (*)");
            imprimirCamino(camino);
            
            System.out.println("\nCELDAS VISITADAS DURANTE LA BÚSQUEDA (v)");
            visitado(celdasVisitadas);

        } else {
            System.out.println("No existe un camino.");
        }
    }

    private boolean findPath(int[][] maze, Celda inicio, Celda fin, List<Celda> camino, Set<Celda> visitadosSet) {

        int fila = inicio.getX();
        int columna = inicio.getY();

        // Fuera del laberinto
        if (fila < 0 || fila >= maze.length || columna < 0 || columna >= maze[0].length) {
            return false;
        }

        // Si es pared (1) o ya fue visitada en el array (2)
        if (maze[fila][columna] == 1 || maze[fila][columna] == 2) {
            return false;
        }

        // Llegó al destino
        if (inicio.equals(fin)) {
            camino.add(0, inicio);
            visitadosSet.add(inicio); // Aseguramos añadir el fin a visitados
            return true;
        }

        // Marcar como visitada en el array y guardarla en el Set
        maze[fila][columna] = 2;
        visitadosSet.add(inicio);

        // Derecha
        if (findPath(maze, new Celda(fila, columna + 1), fin, camino, visitadosSet)) {
            camino.add(0, inicio);
            return true;
        }

        // Abajo
        if (findPath(maze, new Celda(fila + 1, columna), fin, camino, visitadosSet)) {
            camino.add(0, inicio);
            return true;
        }
        // Izquierda
        if (findPath(maze, new Celda(fila, columna - 1), fin, camino, visitadosSet)) {
            camino.add(0, inicio);
            return true;
        }
        // Arriba
        if (findPath(maze, new Celda(fila - 1, columna), fin, camino, visitadosSet)) {
            camino.add(0, inicio);
            return true;
        }

        return false;
    }

    private void imprimirLaberinto() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private void imprimirCamino(List<Celda> camino) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Celda actual = new Celda(i, j);
                if (camino.contains(actual)) {
                    System.out.print("* ");
                } else if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    private void visitado(Set<Celda> visitadosSet) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Celda actual = new Celda(i, j);

                if (visitadosSet.contains(actual)) {
                    System.out.print("v "); // 'v' representa una celda que fue explorada
                } else if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println(); // Salto de línea necesario al terminar cada fila
        }
    }
}