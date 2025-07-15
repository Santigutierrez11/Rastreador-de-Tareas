import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Scanner;

public class RastreadorTareas {
    private static final String FILE_PATH = "tareas.json";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int respuesta;

        menu();
        respuesta = Integer.parseInt(in.nextLine());
        


        try {
            File file = new File(FILE_PATH);
            JSONObject json;

            if (file.exists()) {
                String content = new String(Files.readAllBytes(file.toPath())); // lee el contenido como texto
                json = new JSONObject(content); // lo convierte en un objeto JSONObjete para manipularlo
                System.out.println("El archivo ya existe");
            } else {
                json = new JSONObject(); // Crea un archivo vacio
                json.put("id", 1);
                json.put("descripcion", "");
                json.put("estado", "Sin iniciar");
                json.put("creado", new Date());
                json.put("actualizado", new Date());
            }

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(json.toString(4)); // Escribe el contenido del json en el archivo
                System.out.println("Correcto");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void menu(){
        System.out.println("**** Rastreador de Tareas ****");
        System.out.println("1. Listar tareas");
        System.out.println("2. Modificar tarea");
        System.out.println("3. Crear tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("\nSeleccione una opción: ");
    }
}