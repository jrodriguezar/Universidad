package universidad;

import java.util.ArrayList;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */
public class TProfesional extends Sede{
    
    private int numProgramAltaC;
    private ArrayList<ProgramaForm> programas;

    public TProfesional(String tipo, String nombre, String direccion, int telefono, double areaCons, int numProgramAltaC) {
        super(nombre, direccion, telefono, areaCons, tipo);
        this.numProgramAltaC = numProgramAltaC;
        this.programas=new ArrayList<>();
    }
    
    public boolean addPrograma(String nombre, String descripcion, String nivelFormacion){
        return this.programas.add(new ProgramaForm(nombre,descripcion,nivelFormacion));
    }
    
    @Override
    public void darInformacion(){
        System.out.println("Nombre de la Sede: "+this.nombre);
        System.out.println("Tipo de sede: " + this.tipo);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Telefono: "+this.telefono);
        System.out.println("Área de Construcción: "+this.areaCons);
        System.out.println("Número de programas de alta calidad: "+this.numProgramAltaC);
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
    
    public void programaTecnic(){
        System.out.println("Programas de Formación nivel Técnico");
        for(int i = 0;i<this.programas.size();i++){
            if((this.programas.get(i)!=null)&&(this.programas.get(i).getNivelFormacion().equals("Tecnico"))){
                System.out.println("Nombre: "+this.programas.get(i).getNombre());
                System.out.println("Descripción: "+this.programas.get(i).getDescripcion());
            }
        }
    }
    
    public void programaContinu(){
        System.out.println("Programas de Formación nivel Educación Continua");
        for(int i = 0;i<this.programas.size();i++){
            if((this.programas.get(i)!=null)&&(this.programas.get(i).getNivelFormacion().equals("Continuo"))){
                System.out.println("Nombre: "+this.programas.get(i).getNombre());
                System.out.println("Descripción: "+this.programas.get(i).getDescripcion());
            }
        }
    }
    
    //Para modificar sede

    public void setNumProgramAltaC(int numProgramAltaC) {
        this.numProgramAltaC = numProgramAltaC;
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

    public int getNumProgramAltaC() {
        return numProgramAltaC;
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
