package universidad;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */
public class ProgramaForm {
    
    private String nombre;
    private String descripcion;
    private String nivelFormacion;

    public ProgramaForm(String nombre, String descripcion, String nivelFormacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelFormacion = nivelFormacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }
     
}
