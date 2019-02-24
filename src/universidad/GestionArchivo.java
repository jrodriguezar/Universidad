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
    
    public boolean guardar(ArrayList<Sede> sed) throws IOException{//arreglar para que reescriba lo anterior junt con lo que se agregue, ademas para los programas
        File archivo = new File(this.direccion);
        if(!archivo.exists())
            archivo.createNewFile();
         
        PrintStream salida = 
               new PrintStream(archivo);
        for (Sede sede : sed) {
            if (sede.tipo == "Tecnologica") {
                TTecnologico sedT;
                sedT = (TTecnologico) sede; 
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
                salida.print(",\n");
            }else{
                if (sede.tipo == "Educacion-continuada") {
                    TEducacionConti sedt;
                    sedt = (TEducacionConti) sede;
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
                    salida.print(",\n");
                }else{
                    if(sede.tipo == "Profesional"){
                        TProfesional sedC;
                        sedC =(TProfesional) sede;
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
                        salida.print(",\n");
                    }
                    System.out.println("No hay sedes viables");
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
            String dir = lec.next().trim();//es posible que esto falle, puede que funcione en su luugar nextline
            String num = lec.next().trim();
            int tel = Integer.parseInt(num);
            String are = lec.next().trim();
            double area = Double.parseDouble(are);
            String cursop = lec.next().trim();
             ntc = new TEducacionConti(tip, nom, dir, tel, area, cursop);
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
            String dir = lec.next().trim();//es posible que esto falle
            //System.out.println(dir);
            String num = lec.next().trim();
            int tel = Integer.parseInt(num);
            String are = lec.next().trim();
            double area = Double.parseDouble(are);
            String numM = lec.next().trim();
            //System.out.println(numM);
            int numP = Integer.parseInt(numM);
            ntp = new TProfesional(tip, nom, dir, tel, area, numP);
        
        }catch(Exception e ){
            System.out.println("-e-");
        }
        
        return ntp;
    }
    
    public TTecnologico cargarTecnic(Scanner lec){
        TTecnologico ntt = null;
        try{
            String tip = lec.next().trim();
            String nom = lec.next().trim();
            String dir = lec.next().trim();//es posible que esto falle
            String num = lec.next().trim();
            int tel = Integer.parseInt(num);
            String are = lec.next().trim();
            double area = Double.parseDouble(are);
            String numM = lec.next().trim();
            int numMa = Integer.parseInt(numM);

            ntt = new TTecnologico(tip, nom, dir, tel, area, numMa);
        }catch(Exception e){
            System.out.println("-e-");
        }
        return ntt;
    }
    
    public Sede cargarSede(Scanner lec){ //revisar este try n catch
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