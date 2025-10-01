/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appgestiontareas;

import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class AppGestionTareas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int eleccion=0;
        Scanner userInput=new Scanner(System.in);
        
        do{
            printMenu();
            System.out.println("Indique elección: ");
            String textoEleccion=userInput.nextLine();
            
            if(textoEleccion.matches("[1-6]")){
                //texto elección es solo numeros se puede parsear
                System.out.println("Procesando elección");
                eleccion=Integer.parseInt(textoEleccion);
                
            }else{
                //No se puede parsear si no hay numeros
                System.out.println("ERROR: solo se admite un numero de 1 a 6 para elegir");
            }
            
        }while(eleccion!=6);
    }
    
    //el programa debe permitir
    // 1. crear nueva tarea
    // 2. listar todas las tareas
    // 3. completar tarea
    // 4. eliminar tarea por indice
    // 5. autoeliminar tareas completadas
    // 6. cerrar
    
    private static void printMenu(){
        System.out.println("***App gestión de tareas***");
        System.out.println("   1. Crear nueva tarea");
        System.out.println("   2. Listar todas las tareas");
        System.out.println("   3. Marcar tarea de indice indicado como completada");
        System.out.println("   4. Eliminar tarea de indice indicado");
        System.out.println("   5. Autoeliminar todas las tareas marcadas como completadas");
        System.out.println("   6. Salir");
    }
    
}
