/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appgestiontareas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        Scanner keyboard=new Scanner(System.in);
        
        List<AppTask> tareas=new ArrayList<>();
        
        do{
            PrintMenu();
            System.out.println("Indique elección: ");
            String textoEleccion=keyboard.nextLine();
            
            if(textoEleccion.matches("[1-6]")){
                //texto elección es solo numeros se puede parsear
                System.out.println("Procesando elección");
                eleccion=Integer.parseInt(textoEleccion);
                
                switch(eleccion){
                    case 1:
                        CreateTask(tareas,keyboard);
                        break;
                    case 2:
                        ListAllTasks(tareas);
                        break;
                    case 3:
                        MarkTaskCompleted(tareas,keyboard);
                        break;
                    case 4:
                        DeleteTask(tareas,keyboard);
                        break;
                    case 5:
                        tareas=AutocleanTasks(tareas,keyboard);
                    case 6:
                        System.out.println("*** Saliendo del programa ***");
                        break;
                    default:
                        System.out.println("ERROR: opción no reconocida");
                }
                
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
    
    private static void PrintMenu(){
        System.out.println("***App gestión de tareas***");
        System.out.println("   1. Crear nueva tarea");
        System.out.println("   2. Listar todas las tareas");
        System.out.println("   3. Marcar tarea de indice indicado como completada");
        System.out.println("   4. Eliminar tarea de indice indicado");
        System.out.println("   5. Autoeliminar todas las tareas marcadas como completadas");
        System.out.println("   6. Salir");
    }
    
    private static void CreateTask(List<AppTask> taskList, Scanner keyboard){
        System.out.println("*** Creating new task ***");
        
        System.out.println("Indique nombre de tarea: ");
        String taskName=keyboard.nextLine();
        
        System.out.println("Indique descripción de tarea: ");
        String taskDesc=keyboard.nextLine();
        
        AppTask newTask=new AppTask();
        newTask.setTaskName(taskName);
        newTask.setTaskDescription(taskDesc);
        
        taskList.add(newTask);
    }
    
    private static void ListAllTasks(List<AppTask> taskList){
        System.out.println("*** Listando toda las tareas ***");
        
        //taskList.forEach(task -> System.out.println(task.toString()));
        
        for(int i=0;i<taskList.size();i++){
            System.out.println(i+") "+taskList.get(i).toString());
        }
        
        System.out.println("*** Fin de lista ***");
    }
    
    private static void MarkTaskCompleted(List<AppTask> taskList, Scanner keyboard){
        System.out.println("*** Marcar tarea como completada ***");
        
        System.out.println("Indique índice de tarea para marcar como completada: ");
        try{
            int userInput=keyboard.nextInt();
            
            if(userInput>taskList.size()){
                System.out.println("AVISO: fuera de rango de lista");
                return;
            }
            taskList.get(userInput).setTaskCompleted(true);
            System.out.println("La tarea se marcó como completada con éxito");
        }catch(InputMismatchException e){
            System.err.println("ERROR: no se ha insertado un input válido");
        }
        
    }
    
    private static void DeleteTask(List<AppTask> taskList, Scanner keyboard){
        System.out.println("*** Eliminar tarea ***");
        
        System.out.println("Indique índice de tarea para eliminar: ");
        try{
            int userInput=keyboard.nextInt();
            
            if(userInput>taskList.size()){
                System.out.println("AVISO: fuera de rango de lista");
                return;
            }
            
            AppTask objetivo=taskList.get(userInput);
            
            System.out.println("Encontrado: "+objetivo.toString());
            System.out.println("*** AVISO: al eliminar una trea se perderan sus datos ***");
            System.out.println("*** ¿Está seguro de querer borrarlo? (Y)-> SI,borrar (N)-> NO,conservar ***");
            
            String confirmar=keyboard.nextLine();
            
            if(confirmar.equals("Y")){
                System.out.println("Confirmado, borrando datos...");
                
                taskList.remove(userInput);
                
                System.out.println("Operación completada");
            }else{
                System.out.println("Cancelando operación");
            }
            
        }catch(InputMismatchException e){
            System.err.println("ERROR: no se ha insertado un input válido");
        }
    }
    
    private static List<AppTask> AutocleanTasks(List<AppTask> taskList, Scanner keyboard){
        System.out.println("*** Eliminar tareas completadas ***");
        
        System.out.println("*** AVISO: Se van a eliminar todas las tareas completas ***");
        System.out.println("*** ¿Está seguro de querer borrarlo? (Y)-> SI,borrar (N)-> NO,conservar ***");
        
        String confirmar=keyboard.nextLine();
            
        if(confirmar.equals("Y")){
            System.out.println("Confirmado, borrando datos...");
                
            List<AppTask> newList=new ArrayList<>();
            
            AppTask[] oldTasks=(AppTask[])(taskList.toArray());
            
            for(int i=0;i<taskList.size();i++){
                if(!oldTasks[i].isTaskCompleted()){
                    newList.add(oldTasks[i]);
                }
            }
                
            System.out.println("Operación completada");
            return newList;
        }else{
            System.out.println("Cancelando operación");
        }
        
        return taskList;
    }
    
}
