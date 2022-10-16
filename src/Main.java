import Manager.HistoryManager;
import Manager.InMemoryTaskManager;
import Manager.Managers;
import Manager.TaskManager;
import Model.*;

import java.util.List;

public class Main {

    public static void main(String[] args){
        Managers managers = new Managers();
        TaskManager taskManager = managers.getDefault();

        Epic epic = new Epic("Задача 1", "Описание задачи 1", Status.NEW);
        taskManager.addEpic(epic);
        Subtask subtask = new Subtask("Поздадача 1 Э1", "Описание П1 Э1", Status.NEW,1);
        Subtask subtask1 = new Subtask("Поздадача 2 Э1", "Описание П2 Э1", Status.NEW,1);
        taskManager.addSubtask(subtask, epic.getId());
        taskManager.addSubtask(subtask1, epic.getId());
        subtask.setStatus(Status.DONE);
        taskManager.updateSubtask(subtask);
        Epic epic1 = new Epic("Задача 2", "Описание задачи 2", Status.NEW);
        taskManager.addEpic(epic1);
        Subtask subtask2 = new Subtask("Поздадача 1 Э2", "Описание П1 Э2", Status.NEW,2);
        taskManager.addSubtask(subtask2, epic1.getId());
       // taskManager.deleteAllSubtask();
        taskManager.getEpic(1);
        taskManager.getEpic(1);
        taskManager.getEpic(1);
        taskManager.getEpic(4);
        taskManager.getEpic(4);
        taskManager.getEpic(4);
        taskManager.getEpic(4);
        taskManager.getEpic(4);
        taskManager.getEpic(4);
        taskManager.getEpic(4);
        taskManager.getSubtask(3);
        taskManager.getSubtask(3);


        taskManager.getHistory().stream().forEach(System.out::println);


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