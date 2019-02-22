package universidad;

import java.util.ArrayList;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */
public class TEducacionConti extends Sede {
    
    private String cursoMasPopu;
    private ArrayList<ProgramaForm> programas;

    public TEducacionConti(String tipo, String nombre, String direccion, int telefono, double areaCons, String cursoMasPopu) {
        super(nombre, direccion, telefono, areaCons, tipo);
        this.cursoMasPopu = cursoMasPopu;
        this.programas=new ArrayList<>();
    }

    public TEducacionConti(String nombre, String direccion, int telefono, double areaCons, String tipo) {
        super(nombre, direccion, telefono, areaCons, tipo);
    }
    
    public boolean addPrograma(String nombre, String descripcion, String nivelFormacion){
        return this.programas.add(new ProgramaForm(nombre,descripcion,nivelFormacion));
    }

    @Override
    public void darInformacion() {
        System.out.println("Nombre de la Sede: "+this.nombre);
        System.out.println("Tipo de sede: " + this.tipo);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Telefono: "+this.telefono);
        System.out.println("Área de Construcción: "+this.areaCons);
        System.out.println("Curso más popular: "+this.cursoMasPopu);
        System.out.println("Programas de formación: ");
        if (programas.isEmpty()) {
            System.out.println("No hay programas de formacion registrados aun");
        }else{
            for(int i=0;i<this.programas.size();i++){
                System.out.println("Nombre :"+this.programas.get(i).getNombre());
                System.out.println("Nivel de Formación :"+this.programas.get(i).getNivelFormacion());
                System.out.println("Descripción :"+this.programas.get(i).getDescripcion());
            }
        }
    }
    
    //Para modificar sede

    public void setCursoMapPopu(String cursoMasPopu) {
        this.cursoMasPopu = cursoMasPopu;
    }

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
    
    //Para consultar datos especificos de la sede

    public String getCursoMasPopu() {
        return cursoMasPopu;
    }

    public ArrayList<ProgramaForm> getProgramas() {
        return programas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public double getAreaCons() {
        return areaCons;
    }

    
    
}
