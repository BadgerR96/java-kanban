package Repository;

import Model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskRepo {

    private int nextId = 1;
    private Map<Integer, Task> mapOfTask = new HashMap<>();


    public Task addNewTask(Task task){
        task.setId(nextId++);
        return mapOfTask.put(task.getId(), task);
    }
    public Task updateTask(Task task){
        return mapOfTask.put(task.getId(), task);
    }
    public Task getTaskById (Integer id){
        return mapOfTask.get(id);
    }
    public Task deleteTaskById(Integer id){
        return mapOfTask.remove(id);
    }
    public List<Task> getAllTasks(){
        return mapOfTask.values().stream().collect(Collectors.toList());
    }
    public void deleteAllTask(){
        mapOfTask.clear();
    }

}
