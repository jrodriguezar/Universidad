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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setAreaCons(double areaCons) {
        this.areaCons = areaCons;
    }
    public abstract boolean addPrograma(String nombre, String descripcion, String nivelFormacion);
}
