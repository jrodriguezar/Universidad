package universidad;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */
public abstract class Sede {
    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected double areaCons;
    protected String tipo;

    public Sede(String nombre, String direccion, int telefono, double areaCons, String tipo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.areaCons = areaCons;
        this.tipo = tipo;
    }
    
    public abstract void darInformacion();
    public abstract void setNombre(String nombre);
    public abstract void setDireccion(String direccion);
    public abstract void setTelefono(int telefono);
    public abstract void setAreaCons(double AreaCons);
    public abstract boolean addPrograma(String nombre, String descripcion, String nivelFormacion);
}
