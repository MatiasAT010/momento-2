import java.util.ArrayList;
import java.util.Scanner;

class Tarea {
    String titulo;
    String descripcion;
    String estado;
    String prioridad;

    public Tarea(String titulo, String descripcion, String prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = "Pendiente";
        this.prioridad = prioridad;
    }

    public void mostrar() {
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Estado: " + estado);
        System.out.println("Prioridad: " + prioridad);
    }
}

public class ToDoList {
    static ArrayList<Tarea> tareas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Cambiar estado");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) agregarTarea();
            else if (opcion == 2) mostrarTareas();
            else if (opcion == 3) cambiarEstado();
            else if (opcion == 4) System.out.println("Saliendo...");
            else System.out.println("Opción inválida");
        } while (opcion != 4);
    }

    static void agregarTarea() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Prioridad (Alta/Media/Baja): ");
        String prioridad = sc.nextLine();

        Tarea nueva = new Tarea(titulo, descripcion, prioridad);
        tareas.add(nueva);
        System.out.println("Tarea agregada.");
    }

    static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }

        for (int i = 0; i < tareas.size(); i++) {
            System.out.println("Tarea " + (i + 1));
            tareas.get(i).mostrar();
        }
    }

    static void cambiarEstado() {
        mostrarTareas();
        System.out.print("Número de tarea: ");
        int i = sc.nextInt() - 1;
        sc.nextLine();

        if (i >= 0 && i < tareas.size()) {
            System.out.print("Nuevo estado: ");
            String nuevoEstado = sc.nextLine();
            tareas.get(i).estado = nuevoEstado;
            System.out.println("Estado actualizado.");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
