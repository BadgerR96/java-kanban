package Service;

import Model.Task;
import Repository.TaskRepo;

import java.util.List;

public class TaskService {
    private TaskRepo taskRepo = new TaskRepo();


    public Task addNewTask(Task task){
        return taskRepo.addNewTask(task);
    }
    public Task updateTask(Task task){
        return taskRepo.updateTask(task);
    }
    public Task getTaskById(Integer id){
        return taskRepo.getTaskById(id);
    }
    public Task deleteTaskById(Integer id){
        return taskRepo.deleteTaskById(id);
    }
    public List<Task> getAllTask(){
        return taskRepo.getAllTasks();
    }
    public void deleteAllTasks(){
        taskRepo.deleteAllTask();
    }
}
