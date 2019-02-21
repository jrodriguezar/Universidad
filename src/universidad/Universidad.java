package universidad;

import java.util.ArrayList;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */
public class Universidad {
    private String name;
    private ArrayList<Persona> estudiantes;
    private ArrayList<Sede> sedes;

    public Universidad(String name ) {
        this.name = name;
        this.estudiantes = new ArrayList<>();
        this.sedes = new ArrayList<>();
    }
    
    //Métodos para registrar sedes
    public boolean addSedeTEducacionConti(String cursoMasPopu, String nombre, String direccion, int telefono, double areaCons){
        return this.sedes.add(new TEducacionConti("Educacioncontinuada", nombre, direccion, telefono, areaCons, cursoMasPopu));
    }
    
    public boolean addSedeTProfesional(int numProgramAltaC, String nombre, String direccion, int telefono, double areaCons){
        return this.sedes.add(new TProfesional("Profesional", nombre, direccion, telefono, areaCons, numProgramAltaC));
    }
    
    public boolean addSedeTTecnologica(int numeroMatriculados, String nombre, String direccion, int telefono, double areaCons){
        
        return this.sedes.add(new TTecnologico("Tecnologica", nombre, direccion, telefono, areaCons, numeroMatriculados));
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }
    
    //Método para eliminar una sede  
    public boolean eliminarSede(int pos){
        if (sedes.get(pos) != null){
            sedes.remove(pos);
            return true;
        }else{
            return false;
        }
    }    

    public ArrayList<Sede> getSedes() {
        return sedes;
    }
    
    public Sede getSede(int pos){
        return this.sedes.get(pos);
    }
}
