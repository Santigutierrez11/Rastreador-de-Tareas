import java.util.Date;

public class Tareas {
    private int idTarea;
    private String descripcion;
    private String estado;
    private String creado;
    private String modificado;

    public Tareas(){}
    public Tareas(int idTarea, String descripcion, String estado, String creado, String modificado){
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
        this.creado = creado;
        this.modificado = modificado;
    }

    public int getIdTarea() {
        return this.idTarea;
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
        return "Tareas" +
                "{" +
                "\n\tid: " + this.idTarea + '\n' +
                "\tdescripcion='" + this.descripcion + '\n' +
                "\testado='" + this.estado + '\n' +
                "\tcreado=" + this.creado + '\n' +
                "\tmodificado=" + this.modificado + '\n' +
                '}';
    }
}