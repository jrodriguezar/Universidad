package universidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jhon
 */
public class GestionArchivo {
    
    private String direccion;

    public GestionArchivo(String direccion) {
        this.direccion = direccion;
    }
    
    public boolean guardar(ArrayList<Sede> sed) throws IOException{//areglar para que se adecue a el formato predilecto
        File archivo = new File(this.direccion);
        if(!archivo.exists())
            archivo.createNewFile();
         
        PrintStream salida = 
               new PrintStream(archivo);
        for (Sede sede : sed) {
            salida.print(sede.toString());
            salida.print(" ");
        }
        salida.flush();
        salida.close();
        return true;
    }
    
    public TEducacionConti cargarEduC(Scanner lec){
        
        TEducacionConti ntc = null;
        
        String tip = lec.next().trim();
        String nom = lec.next().trim();
        String dir = lec.next().trim();//es posible que esto falle, puede que funcione en su luugar nextline
        String num = lec.next().trim();
        int tel = Integer.parseInt(num);
        String are = lec.next().trim();
        double area = Double.parseDouble(are);
        String cursop = lec.next().trim();
        
        ntc = new TEducacionConti(tip, nom, dir, tel, area, cursop);
        
        return ntc;
    }
    
    public TProfesional cargarPro(Scanner lec){
        
        TProfesional ntp = null;
        
        String tip = lec.next().trim();
        String nom = lec.next().trim();
        String dir = lec.next().trim();//es posible que esto falle
        String num = lec.next().trim();
        int tel = Integer.parseInt(num);
        String are = lec.next().trim();
        double area = Double.parseDouble(are);
        String numM = lec.next().trim();
        int numP = Integer.parseInt(numM);
        
        ntp = new TProfesional(tip, nom, dir, tel, area, numP);
        
        return ntp;
    }
    
    public TTecnologico cargarTecnic(Scanner lec){
        TTecnologico ntt = null;
        
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
        
        return ntt;
    }
    
    public Sede cargarSede(Scanner lec){
        String type = lec.next().trim();
        
        if (type.equals("Tecnica")){
            return cargarTecnic(lec);
        }else{
            if (type.equals("Educacion-continuada")) return cargarEduC(lec);
            
            return cargarPro(lec);
        }
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