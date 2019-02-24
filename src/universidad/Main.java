
package universidad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @authors Jhon Rodríguez, Diana Madero, Kevin Jiménez
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Creando universidad
        Universidad universidad = new Universidad("Nacho");
        
        Scanner lectura = new Scanner(System.in);
        int a=0;
        String n = "Universidad.txt";
        GestionArchivo ga = new GestionArchivo(n);
        try{
              universidad.setSedes(ga.cargar());
        }catch(FileNotFoundException e){
            System.out.println("File not found -- " + n);
            e.printStackTrace();
        }
        
        do{
            System.out.println("Opciones");
            System.out.println("1.Registrar nueva sede");
            System.out.println("2.Eliminar sede");
            System.out.println("3.Modificar sede");
            System.out.println("4.Consultar sede");
            System.out.println("5.Agregar programa a sede");
            System.out.println("6.Guardar");
            System.out.println("7.Terminar sesión");
            System.out.println("Digite el número de la opción que desea elegir");
            a = lectura.nextInt();
            
            int b = 0;
            switch(a){ 
                case 1:
                    System.out.println("1.Registrar sede de tipo profesional");
                    System.out.println("2.Registrar sede de tipo tecnologia");
                    System.out.println("3.Registrar sede de tipo continuada");
                    System.out.println("Digite el número de la opción");
                    b=lectura.nextInt();
                    
                    switch(b){
                        case 1:
                            System.out.println("Digite el nombre de la sede: ");
                            String nombre = lectura.next();
                            System.out.println("Digite la direccion de la sede: ");
                            String direccion = lectura.next();
                            System.out.println("Digite el telefono de la sede: ");
                            String telef = lectura.next();
                            int telefono = Integer.parseInt(telef);
                            System.out.println("Digite el área de construcción de la sede: ");
                            String ar = lectura.next();
                            double area = Double.parseDouble(ar);
                            
                            if(universidad.addSedeTProfesional(0, nombre, direccion, telefono, area)){
                                System.out.println("La sede se ha registrado exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            break;
                        case 2:
                            System.out.println("Digite el nombre de la sede: ");
                            String nombreT = lectura.next();
                            System.out.println("Digite la direccion de la sede: ");
                            String direccionT = lectura.next();
                            System.out.println("Digite el telefono de la sede: ");
                            String te = lectura.next();
                            int telefonoT = Integer.parseInt(te);
                            System.out.println("Digite el área de construcción de la sede: ");
                            String art = lectura.next();
                            double areaT = Double.parseDouble(art);
                            
                            if(universidad.addSedeTTecnologica(0, nombreT, direccionT, telefonoT, areaT)){
                                System.out.println("La sede se ha registrado exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            break;
                        case 3:
                            System.out.println("Digite el nombre de la sede: ");
                            String nombreC = lectura.next();
                            System.out.println("Digite la direccion de la sede: ");
                            String direccionC = lectura.next();
                            System.out.println("Digite el telefono de la sede: ");
                            String telC = lectura.next();
                            int telefonoC = Integer.parseInt(telC);
                            System.out.println("Digite el área de construcción de la sede: ");
                            String arC = lectura.next();
                            double areaC = Double.parseDouble(arC);
                            
                            if(universidad.addSedeTEducacionConti("nell", nombreC, direccionC, telefonoC, areaC)){
                                System.out.println("La sede se ha registrado exitosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                            try{
                            for(Sede sede: universidad.getSedes())
                                System.out.println(sede.tipo);
                            }catch(Exception e){}
                            break;
                    }
                    break;
                case 2:
                    if (universidad.getSedes().isEmpty()) {
                        System.out.println("No hay sedes existentes");
                    }else{
                        System.out.println("Listado de sedes: ");
                        int i = 0;
                        try{
                            for(Sede nombre : universidad.getSedes()){
                                System.out.println(i + ".Nombre: "+ nombre.nombre);
                                System.out.println(" Tipo de Sede: " + nombre.tipo);
                                i++;
                            }
                        }catch(Exception e){}    
                        System.out.println("Digite la posicion de la sede que desea eliminar");
                        int pos = lectura.nextInt();
                        if (pos > (universidad.getSedes().size()-1)) {
                            System.out.println("No existe una sede en esa posicion");
                        }else{
                            if(universidad.eliminarSede(pos)){
                                System.out.println("Operación realizada existosamente");
                            }else{
                                System.out.println("Ocurrio un error");
                            }
                        }
                    }
                    break;
                case 3:
                try{
                    if (universidad.getSedes().isEmpty()) {
                        System.out.println("No hay sedes existentes");
                    }else{
                        System.out.println("Listado de sedes: ");
                        int p = 0;
                        try{
                            for(Sede nombre : universidad.getSedes()){
                                System.out.println(p + ".Nombre: "+ nombre.nombre);
                                System.out.println("  Tipo de Sede: " + nombre.tipo);
                                p++;
                            }
                        }catch(Exception e){
                        }
                        System.out.println("Digite la posicion de la sede: ");
                        int posA = lectura.nextInt();

                
                            universidad.getSedes().get(posA);
                            System.out.println("No existe una sede en esa posicion");
                            System.out.println("Items para modificar: ");
                            System.out.println("1.Nombre");
                            System.out.println("2.Direccion");
                            System.out.println("3.Telefono");
                            System.out.println("4.Area Construida");
                            System.out.println("Digite el número de la opción que desea escoger: ");
                            int c=lectura.nextInt();

                            switch(c){
                                case 1:
                                    System.out.println("Nombre actual: " + universidad.getSedes().get(posA).nombre);
                                    System.out.println("Digite el nuevo nombre de la sede: ");
                                    String Nnombre = lectura.next();
                                    universidad.getSedes().get(posA).setNombre(Nnombre);
                                    break;
                                case 2:
                                    System.out.println("Direccion actual: " + universidad.getSedes().get(posA).direccion);
                                    System.out.println("Ingrese la nueva direccion: ");
                                    String direc = lectura.next();
                                    universidad.getSedes().get(posA).setDireccion(direc);
                                    break; 
                                case 3:
                                    System.out.println("Telefono actual: " + universidad.getSedes().get(posA).telefono);
                                    System.out.println("Ingrese el nuevo telefono: ");
                                    int num = lectura.nextInt();
                                    universidad.getSedes().get(posA).setTelefono(num);
                                    break;
                                case 4:
                                    System.out.println("Tamanio actual del area construida: " + universidad.getSedes().get(posA).areaCons + " metros cuadrados");
                                    System.out.println("Ingrese la nueva area construida: ");
                                    double ares = lectura.nextDouble();
                                    universidad.getSedes().get(posA).setAreaCons(ares);
                                    break;
                            }

                }
                }catch(NullPointerException e ){
                        System.out.println("No hay sedes en esta posicion");
                        break;
                }catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("La posicion señalada es incorrecta");
                        break;
                    }
                break;
                case 4:
                    if (universidad.getSedes().isEmpty()) {
                        System.out.println("No hay sedes existentes");
                    }else{
                        System.out.println("Listado de sedes: ");
                        int p = 0;
                        try{
                            for(Sede nombre : universidad.getSedes()){
                                System.out.println(p + ".Nombre: "+ nombre.nombre);
                                System.out.println("  Tipo de Sede: " + nombre.tipo);
                                p++;
                            }
                        }catch(Exception e){}    
                        System.out.println("Digite la posicion de la sede que desea consultar: ");
                        int posC = lectura.nextInt();
                        if (posC > (universidad.getSedes().size()-1)) {
                            System.out.println("No existe una sede en esa posicion");
                        }else{
                            universidad.getSedes().get(posC).darInformacion();
                        }    
                    }
                    break;    
                case 5:
                    if (universidad.getSedes().isEmpty()) {
                        System.out.println("No hay sedes existentes");
                    }else{
                        System.out.println("Listado de sedes: ");
                        int p = 0;
                        try{
                            for(Sede nombre : universidad.getSedes()){
                                System.out.println(p + ".Nombre: "+ nombre.nombre);
                                System.out.println("  Tipo de Sede: " + nombre.tipo);
                                p++;
                            }
                        }catch(Exception e){
                            System.out.println("no hay sedes que modificar");
                        }    
                        System.out.println("Digite la posicion de la sede que desea consultar: ");
                        int posD = lectura.nextInt();
                        if (posD > (universidad.getSedes().size()-1)) {
                            System.out.println("No existe una sede en esa posicion");
                        }else{
                            System.out.println("Digite el nombre del programa: ");
                            String nombreP = lectura.next();
                            System.out.println("Digite la descripción del programa: ");
                            String descripcionP = lectura.next();
                            System.out.println("Digite el nivel de formacion del programa (Tecnico, Continuo, Profesional): ");
                            String nivelP = lectura.next();
                            universidad.getSede(posD).addPrograma(nombreP, descripcionP, nivelP);
                        }
                    }
                    break;
                case 6:
                    ArrayList<Sede> feg;
                    feg = universidad.getSedes();
                    try{
                        ga.guardar(feg);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Sesión terminada. Muchas gracias. EXCELENTE DÍA");
                    a=9;
                    break;
            }
        }while((0<a)&&(a<8));
    }
}