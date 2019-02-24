package universidad;

import java.util.ArrayList;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */

public class TTecnologico extends Sede{
    
    private int numeroMatriculados;
    private ArrayList<ProgramaForm> programas;

    public TTecnologico(String tipo, String nombre, String direccion, int telefono, double areaCons, int numeroMatriculados) {
        super(nombre, direccion, telefono, areaCons, tipo);
        this.numeroMatriculados = numeroMatriculados;
        this.programas=new ArrayList<>();
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
        System.out.println("Número de matriculados: "+this.numeroMatriculados);
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

    public void setNumeroMatriculados(int numeroMatriculados) {
        this.numeroMatriculados = numeroMatriculados;
    }
    
    //Para consultar datos especificos de la sede

    public int getNumeroMatriculados() {
        return numeroMatriculados;
    }
    
    public ArrayList<ProgramaForm> getProgramas(){
        return this.programas;
    }
}
