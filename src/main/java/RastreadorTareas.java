import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;

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
                    System.out.println("* Lista tareas *");
                    listarTareas();
                    break;
                case 2:
                    System.out.println("Modificar tarea");
                    System.out.print("Ingresa el ID de la tarea: ");
                    int idTarea = Integer.parseInt(in.nextLine());
                    modificarTarea(idTarea);
                    break;
                case 3:
                    System.out.println("* Crear tarea *");
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

    public static String estados(){
        Scanner in = new Scanner(System.in);
        byte respuesta = 0;
        String estado;

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

        while(true){
            if(respuesta >= 1 && respuesta <= 3){
                switch(respuesta){
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
        return estado;
    }
    
    public static void listarTareas(){
        ObjectMapper mapper = new ObjectMapper();
        List<Tareas> tareasLista = new ArrayList<>();

        try {
            File archivo = new File(FILE_PATH);

            if(archivo.exists() && archivo.length() > 0){
                tareasLista = mapper.readValue(archivo, new TypeReference<List<Tareas>>() {});
                for(Tareas tarea : tareasLista){
                    System.out.println("ID: " + tarea.getIdTarea());
                    System.out.println("\tDescripción: " + tarea.getDescripcion());
                    System.out.println("\tEstado: " + tarea.getEstado());
                    System.out.println("\tCreado: " + tarea.getCreado());
                    System.out.println("\tModificado: " + tarea.getModificado());
                    System.out.println();
                }
            } else {
                System.out.println("No existes tareas");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void agregarTarea(){
        Scanner in = new Scanner(System.in);
        int idTarea = 1;
        ObjectMapper mapper = new ObjectMapper();
        List<Tareas> tareasLista = new ArrayList<>();

        try {
            File archivo = new File(FILE_PATH);

            if(archivo.exists() && archivo.length() > 0){
                tareasLista = mapper.readValue(archivo, new TypeReference<List<Tareas>>() {});
                Tareas ultimaTarea = tareasLista.getLast();
                idTarea = ultimaTarea.getIdTarea() + 1;
            }

            System.out.print("Ingresa la descripción: ");
            String descripcion = in.nextLine();


            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String creado = formatoFecha.format(fechaActual);

            Tareas tarea = new Tareas(idTarea, descripcion, estados(), creado, creado);
            tareasLista.add(tarea);

            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, tareasLista);
            System.out.println("Tarea agregada :)");
        } catch (IOException e){
            System.err.println("Error al procesar el archivo: JSON: ");
            e.printStackTrace();
        }
    }

    public static void modificarTarea(int idTarea){
        Scanner in = new Scanner(System.in);
        ObjectMapper  mapper = new ObjectMapper();
        List<Tareas> tareasLista = new ArrayList<>();

        try {
            File archivo = new File(FILE_PATH);
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            if(archivo.exists() && archivo.length() > 0){
                tareasLista = mapper.readValue(archivo, new TypeReference<List<Tareas>>() {});

                System.out.print("Ingresa nueva descripcion: ");
                String descripcion = in.nextLine();

                for(Tareas tarea : tareasLista){
                    if(tarea.getIdTarea() == idTarea){
                        tarea.setDescripcion(descripcion + " - " + tarea.getDescripcion());
                        tarea.setEstado(estados());
                        tarea.setModificado(formatoFecha.format(fechaActual));
                    }
                }

                mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, tareasLista);
                System.out.println("Tarea actualizada :)");
            } else {
                System.out.println("No existen tareas");
            }

        } catch (IOException e){
            System.err.println("Error al procesar el archivo: JSON: ");
            e.printStackTrace();
        }
    }

    public static void eliminarTarea(){

    }
}