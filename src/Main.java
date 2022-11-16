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

        Epic epic = new Epic("Эпик 1", "Описание задачи 1", Status.NEW);
        Epic epic1 = new Epic("Эпик 2", "Описание задачи 2", Status.NEW);
        Task task = new Task("Задача 1","Описание задачи 1", Status.NEW);
        Task task2 = new Task("Задача 2","Описание задачи 2", Status.IN_PROGRES);


        Subtask subtask = new Subtask("Поздадача 1 Э1", "Описание П1 Э1", Status.NEW,1);
        Subtask subtask1 = new Subtask("Поздадача 2 Э1", "Описание П2 Э1", Status.NEW,1);
        Subtask subtask2 = new Subtask("Поздадача 3 Э1", "Описание П3 Э1", Status.NEW,1);
        taskManager.addEpic(epic);

        taskManager.addSubtask(subtask, epic.getId());
        taskManager.addSubtask(subtask1, epic.getId());
        taskManager.addSubtask(subtask2, epic.getId());
        subtask.setStatus(Status.DONE);
        taskManager.updateSubtask(subtask);

        taskManager.addEpic(epic1);
        taskManager.addTask(task);
        taskManager.addTask(task2);

       // taskManager.deleteAllSubtask();
        taskManager.getEpic(1);
        taskManager.getEpic(5);
        taskManager.getEpic(1);
        taskManager.getEpic(5);
        taskManager.getTask(6);
        taskManager.getEpic(5);
        taskManager.getEpic(1);
        taskManager.getEpic(5);
        taskManager.getEpic(1);
        taskManager.getEpic(5);
        taskManager.getEpic(5);
        taskManager.getSubtask(2);
        taskManager.getSubtask(3);
        taskManager.getTask(7);
        taskManager.getTask(6);
        taskManager.getTask(7);
        taskManager.getEpic(5);
        taskManager.getTask(6);


        System.out.println("****************************************");


        taskManager.getHistory().stream().forEach(System.out::println);

        System.out.println("*****************************************");


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