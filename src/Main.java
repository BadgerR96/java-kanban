import Manager.TaskManager;
import Model.Epic;
import Model.Status;
import Model.Subtask;
import Model.Task;

import java.util.List;

public class Main {

    public static void main(String[] args){
        TaskManager taskManager = new TaskManager();
        Epic epic = taskManager.generateEpic("Задача 1", "Описание задачи 1", Status.NEW);
        taskManager.addEpic(epic);
        Subtask subtask = taskManager.generateSubtask("Поздадача 1 Э1", "Описание П1 Э1", Status.NEW,2);
        Subtask subtask1 = taskManager.generateSubtask("Поздадача 2 Э1", "Описание П2 Э1", Status.NEW,2);
        taskManager.addSubtask(subtask, epic.getId());
        taskManager.addSubtask(subtask1, epic.getId());
        subtask.setStatus(Status.DONE);
        taskManager.updateSubtask(subtask);
        Epic epic1 = taskManager.generateEpic("Задача 2", "Описание задачи 2", Status.NEW);
        taskManager.addEpic(epic1);
        Subtask subtask2 = taskManager.generateSubtask("Поздадача 1 Э2", "Описание П1 Э2", Status.NEW,8);
        taskManager.addSubtask(subtask2,epic.getId());
        

        List<Epic> listOfEpic = taskManager.getAllEpic();
        for (Epic epics : listOfEpic) {
            System.out.println(epics.toString());
        }
        List<Subtask> listOfSubtask = taskManager.getAllSubtask();
        for(Subtask subtasks : listOfSubtask){
            System.out.println(subtasks.toString());
        }
    }
}