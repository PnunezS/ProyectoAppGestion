/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgestiontareas;

/**
 *
 * @author daw2
 */
public class AppTask {
    private String taskName="task";
    private String taskDescription="dummy task";
    private boolean taskCompleted=false;

    public AppTask() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    @Override
    public String toString() {
        return "AppTask{" + "taskName=" + taskName + ", taskDescription=" + taskDescription + ", taskCompleted=" + taskCompleted + '}';
    }
    
    
}
