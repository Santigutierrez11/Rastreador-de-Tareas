import java.util.Date;

public class Tareas {
    private static int id;
    private String descripcion;
    private String estado;
    private Date creado;
    private Date modificado;

    public Tareas(){
        Tareas.id++;
    }
    public Tareas(String descripcion, String estado, Date creado, Date modificado){
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

    public Date getCreado() {
        return this.creado;
    }
    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return this.modificado;
    }
    public void setModificado(Date modificado) {
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