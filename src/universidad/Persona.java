package universidad;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */
public class Persona {
    
    private boolean bachiller;
    private String nombre;
    private String apellido;
    private String colegioGrad;
    private int anioGrad;
    private ProgramaForm programa;

    public Persona(boolean bachiller, String nombre, String apellido, String colegioGrad, int anioGrad) {
        this.bachiller = bachiller;
        this.nombre = nombre;
        this.apellido = apellido;
        this.colegioGrad = colegioGrad;
        this.anioGrad = anioGrad;
    }

    public Persona(boolean bachiller, String nombre, String apellido) {
        this.bachiller = bachiller;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
