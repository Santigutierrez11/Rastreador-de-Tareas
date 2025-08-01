import java.util.Date;

public class Tareas {
    private static int id;
    private String descripcion;
    private String estado;
    private String creado;
    private String modificado;

    public Tareas(){
        Tareas.id++;
    }
    public Tareas(String descripcion, String estado, String creado, String modificado){
        this();
        this.descripcion = descripcion;
        this.estado = estado;
        this.creado = creado;
        this.modificado = modificado;
    }

    public static int getId() {
        return Tareas.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return this.estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreado() {
        return this.creado;
    }
    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getModificado() {
        return this.modificado;
    }
    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "id: " + Tareas.id + '\n' +
                "descripcion='" + this.descripcion + '\n' +
                ", estado='" + this.estado + '\n' +
                ", creado=" + this.creado + '\n' +
                ", modificado=" + this.modificado + '\n' +
                '}';
    }
}