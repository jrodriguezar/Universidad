package universidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */

public class GestionArchivo {
    
    private String direccion;

    public GestionArchivo(String direccion) {
        this.direccion = direccion;
    }
    
    public boolean guardar(ArrayList<Sede> sed) throws IOException{
        File archivo = new File(this.direccion);
        if(!archivo.exists())
            archivo.createNewFile();
        
        PrintStream salida = 
               new PrintStream(archivo);
        for (int i = 0; i<sed.size();i++) {
            if (sed.get(i).tipo.equals("Tecnologica")) {
                TTecnologico sedT;
                sedT = (TTecnologico) sed.get(i); 
                salida.print(sedT.tipo);
                salida.print(",");
                salida.print(sedT.tipo);
                salida.print(",");
                salida.print(sedT.nombre);
                salida.print(",");
                salida.print(sedT.direccion);
                salida.print(",");
                salida.print(sedT.telefono);
                salida.print(",");
                salida.print(sedT.areaCons);
                salida.print(",");
                salida.print(sedT.getNumeroMatriculados());
                salida.print(",");
                for (int j = 0; j < sedT.getProgramas().size(); j++) {
                    salida.print(sedT.getProgramas().get(j).getNivelFormacion());
                    salida.print(",");
                    salida.print(sedT.getProgramas().get(j).getNombre());
                    salida.print(",");
                    salida.print(sedT.getProgramas().get(j).getDescripcion());
                    salida.print(",");
                }
                if (i!=sed.size()-1) {
                    salida.print("\n");
                }
            }else{
                if (sed.get(i).tipo.equals("Educacion-continuada")) {
                    TEducacionConti sedt = null;
                    sedt = (TEducacionConti) sed.get(i);
                    salida.print(sedt.tipo);
                    salida.print(",");
                    salida.print(sedt.tipo);
                    salida.print(",");
                    salida.print(sedt.nombre);
                    salida.print(",");
                    salida.print(sedt.direccion);
                    salida.print(",");
                    salida.print(sedt.telefono);
                    salida.print(",");
                    salida.print(sedt.areaCons);
                    salida.print(",");
                    salida.print(sedt.getCursoMasPopu());
                    salida.print(",");
                    for (int j = 0; j < sedt.getProgramas().size(); j++) {
                        salida.print(sedt.getProgramas().get(j).getNivelFormacion());
                        salida.print(",");
                        salida.print(sedt.getProgramas().get(j).getNombre());
                        salida.print(",");
                        salida.print(sedt.getProgramas().get(j).getDescripcion());
                        salida.print(",");
                    }
                    if (i!=sed.size()-1) {
                        salida.print("\n");
                    }
                }else{
                    if(sed.get(i).tipo.equals("Profesional")){
                        TProfesional sedC = null;
                        sedC =(TProfesional) sed.get(i);
                        salida.print(sedC.tipo);
                        salida.print(",");
                        salida.print(sedC.tipo);
                        salida.print(",");
                        salida.print(sedC.nombre);
                        salida.print(",");
                        salida.print(sedC.direccion);
                        salida.print(",");
                        salida.print(sedC.telefono);
                        salida.print(",");
                        salida.print(sedC.areaCons);
                        salida.print(",");
                        salida.print(sedC.getNumProgramAltaC());
                        salida.print(",");
                        for (int j = 0; j < sedC.getProgramas().size(); j++) {
                            salida.print(sedC.getProgramas().get(j).getNivelFormacion());
                            salida.print(",");
                            salida.print(sedC.getProgramas().get(j).getNombre());
                            salida.print(",");
                            salida.print(sedC.getProgramas().get(j).getDescripcion());
                            salida.print(",");
                        }
                        if (i!=sed.size()-1) {
                            salida.print("\n");
                        }
                    }  
                }
            }
        }
        salida.flush();
        salida.close();
        return true;
    }
    
    public TEducacionConti cargarEduC(Scanner lec){
        
        TEducacionConti ntc = null;
        try{
            String tip = lec.next().trim();
            String nom = lec.next().trim();
            String dir = lec.next().trim();
            String num = lec.next().trim();
            int tel = Integer.parseInt(num);
            String are = lec.next().trim();
            double area = Double.parseDouble(are);
            String cursop = lec.next().trim();
            ntc = new TEducacionConti(tip, nom, dir, tel, area, cursop);
            
            for (int i = 0; i < 100; i++) {
                if (lec.hasNext("PTecnologico")||lec.hasNext("PProfesional")||lec.hasNext("PEducacioncontinua")) {
                    String nivp = lec.next().trim();
                    String namep = lec.next().trim();
                    String desp = lec.next().trim();

                    ntc.addPrograma(namep, desp, nivp);
                }else{
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("-e-");
        }            
        return ntc;
    }
    
    public TProfesional cargarPro(Scanner lec){
        
        TProfesional ntp = null;
        try{
            String tip = lec.next().trim();
            //System.out.println(tip);
            String nom = lec.next().trim();
            //System.out.println(nom);
            String dir = lec.next().trim();
            //System.out.println(dir);
            String num = lec.next().trim();
            int tel = Integer.parseInt(num);
            String are = lec.next().trim();
            double area = Double.parseDouble(are);
            String numM = lec.next().trim();
            //System.out.println(numM);
            int numP = Integer.parseInt(numM);
            ntp = new TProfesional(tip, nom, dir, tel, area, numP);
            
            
            for (int i = 0; i < 100; i++) {
                if (lec.hasNext("PTecnologico")||lec.hasNext("PProfesional")||lec.hasNext("PEducacioncontinua")) {
                    String nivp = lec.next().trim();
                    String namep = lec.next().trim();
                    String desp = lec.next().trim();

                    ntp.addPrograma(namep, desp, nivp);
                }else{
                    break;
                }
            }
            
        }catch(Exception e ){
            System.out.println("-e-");
        }
        
        return ntp;
    }
    
    public TTecnologico cargarTecnic(Scanner lec){
        //lec.reset();
        TTecnologico ntt = null;
        try{
            String tip = lec.next().trim();
            String nom = lec.next().trim();
            String dir = lec.next().trim();
            String num = lec.next().trim();
            int tel = Integer.parseInt(num);
            String are = lec.next().trim();
            double area = Double.parseDouble(are);
            String numM = lec.next().trim();
            int numMa = Integer.parseInt(numM);

            ntt = new TTecnologico(tip, nom, dir, tel, area, numMa);
            
            for (int i = 0; i < 100; i++) {
                if (lec.hasNext("PTecnologico")||lec.hasNext("PProfesional")||lec.hasNext("PEducacioncontinua")) {
                    String nivp = lec.next().trim();
                    String namep = lec.next().trim();
                    String desp = lec.next().trim();

                    ntt.addPrograma(namep, desp, nivp);
                }else{
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("-e-");
        }
        return ntt;
    }
    
    public Sede cargarSede(Scanner lec){ 
        String type = lec.next().trim();
        try{
            if (type.equals("Tecnologica")){
                return cargarTecnic(lec);
            }else{
                if (type.equals("Educacion-continuada")) return cargarEduC(lec);        
            
            }
        }catch(Exception e){
            System.out.println("-e-");
        }    
        return cargarPro(lec);
    }
    
    public ArrayList<Sede> cargar() throws FileNotFoundException{
        ArrayList<Sede> data = new ArrayList<>();
        Scanner lectura;
       
        try {
            lectura = new Scanner(new File(this.direccion));
            lectura.useDelimiter(",");
            
            while (lectura.hasNext()) {
                data.add(cargarSede(lectura));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found -- " + this.direccion);
            e.printStackTrace();
        }
        return data;
    }
}