package Service;

import Model.Dictionary;
import Model.Epic;
import Model.Subtask;
import Model.Task;

import java.util.List;

public class MainService {
    private TaskService taskService = new TaskService();
    EpicService epicService = new EpicService();


    public void start(){
        Task task = new Task();
        task.setTitle("Задача 1");
        task.setDescription("Описание задачи 1");
        task.setStatus(Dictionary.NEW);
        taskService.addNewTask(task);
        Task task1 = new Task();
        task1.setTitle("Задача 2");
        task1.setDescription("Описание задачи2");
        task1.setStatus(Dictionary.NEW);
        taskService.addNewTask(task1);
        Epic epic = new Epic();
        epic.setTitle("Эпик 1");
        epic.setDescription("Описание Эпика 1");
        epic.setStatus(Dictionary.NEW);
        epicService.addNewEpic(epic);
        Epic epic1 = new Epic();
        epic1.setTitle("Эпик 2");
        epic1.setDescription("Описание Эпика 1");
        epic1.setStatus(Dictionary.NEW);
        epicService.addNewEpic(epic1);
        Subtask subtask = new Subtask();
        subtask.setTitle("Подзадача Эпика 1");
        subtask.setDescription("Описание подзадачи Эпика 1");
        subtask.setStatus(Dictionary.NEW);
        epic.addSubtaskInList(subtask);
        Subtask subtask1 = new Subtask();
        subtask1.setTitle("Подзадача 1 Эпика 2");
        subtask1.setDescription("Описание подзадачи 1 Эпика 2");
        subtask1.setStatus(Dictionary.NEW);
        epic1.addSubtaskInList(subtask1);
        Subtask subtask2 = new Subtask();
        subtask2.setTitle("Подзадача 2 Эпика 2");
        subtask2.setDescription("Описание Подзадачи 2 Эпика 2");
        subtask2.setStatus(Dictionary.NEW);
        epic1.addSubtaskInList(subtask2);
        subtask.setStatus(Dictionary.DONE);
        epicService.updateEpic(epic);
        subtask1.setStatus(Dictionary.IN_PROGRES);
        epicService.updateEpic(epic1);


    }
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }
    public List<Epic> getAllEpic(){
        return epicService.getAllEpic();
    }
    public List<Subtask> getAllSubtask(Integer id){
        return epicService.getAllSubtask(id);
    }
}
