import Model.Epic;
import Model.Subtask;
import Model.Task;
import Service.MainService;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        MainService mainService = new MainService();
        mainService.start();
        List<Task> listOfTask = mainService.getAllTasks();
        for(Task task : listOfTask){
            System.out.println(task.toString());
        }
        List<Epic> listOfEpic = mainService.getAllEpic();
        for(Epic epic : listOfEpic){
            System.out.println(epic.toString());
        }
        List<Subtask> listOfSubtask = mainService.getAllSubtask(1).stream().peek(subtask -> System.out.println(subtask)).collect(Collectors.toList());

    }
}
