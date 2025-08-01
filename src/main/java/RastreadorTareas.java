import java.util.Scanner;

public class RastreadorTareas {
    private static final String FILE_PATH = "tareas.json";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int respuesta;

        do {
            menu();
            respuesta = Integer.parseInt(in.nextLine());
            switch(respuesta){
                case 1:
                    System.out.println("Listar tareas");
                    break;
                case 2:
                    System.out.println("Modificar tarea");
                    break;
                case 3:
                    System.out.println("Crear tarea");
                    break;
                case 4:
                    System.out.println("Eliminar tarea");
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println();
        } while (respuesta != 5);


    }

    public static void menu(){
        System.out.print("**** Rastreador de Tareas ****");
        System.out.print("\n+-------------------+");
        System.out.print("\n|1. Listar tareas   |");
        System.out.print("\n|2. Modificar tarea |");
        System.out.print("\n|3. Crear tarea     |");
        System.out.print("\n|4. Eliminar tarea  |");
        System.out.print("\n|5. Salir           |");
        System.out.println("\n+-------------------+");
        System.out.print("\nSeleccione una opción: ");
    }
    
    public static void listarTareas(){

    }

    public static void agregarTarea(){

    }

    public static void modificarTarea(){

    }

    public static void eliminarTarea(){

    }
}