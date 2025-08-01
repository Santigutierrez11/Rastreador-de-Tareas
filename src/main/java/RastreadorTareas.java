import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
                    System.out.println("*** Crear tarea ***");
                    agregarTarea();
                    break;
                case 4:
                    System.out.println("Eliminar tarea");
                    break;
                case 5:
                    System.out.println("Adios...");
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

    public static byte estados(){
        Scanner in = new Scanner(System.in);
        byte respuesta = 0;
        System.out.print("**** Estados de la tareas ****");
        System.out.print("\n+-------------------+");
        System.out.print("\n|1. Sin iniciar   |");
        System.out.print("\n|2. En progreso |");
        System.out.print("\n|3. Terminada     |");
        System.out.println("\n+-------------------+");
        System.out.print("\nSeleccione una opción: ");
        try{
            respuesta = Byte.parseByte(in.nextLine());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return respuesta;
    }
    
    public static void listarTareas(){

    }

    public static void agregarTarea(){
        Scanner in = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();

        System.out.print("Ingresa la descripción: ");
        String descripcion = in.nextLine();
        String estado;

        while(true){
            byte estadoResultado = estados();
            if(estadoResultado >= 1 && estadoResultado <= 3){
                switch(estadoResultado){
                    case 1:
                        estado = "Sin iniciar";
                        break;
                    case 2:
                        estado = "En progreso";
                        break;
                    default:
                        estado = "Terminada";
                        break;
                }
                break;
            } else {
                System.out.println("Opción no valida");
            }
        }

        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String creado = formatoFecha.format(fechaActual);

        Tareas tarea = new Tareas(descripcion, estado, creado, creado);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), tarea);
            System.out.println("Tarea agregada :)");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void modificarTarea(){

    }

    public static void eliminarTarea(){

    }
}